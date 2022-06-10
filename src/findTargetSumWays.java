/**
 * @author diaopx
 * @date 2022/4/7 14:13
 * <p>
 * 494.目标和
 */
public class findTargetSumWays {

    /*int[] nums;
    int target;
    int n, ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int index, int cur) {
        if (index == n) {
            // 叶子结点  判断是否是答案。
            if (cur == target) {
                ans++;
            }
            return;
        }
        // 当前节点 选择正负两个情况
        dfs(index + 1, cur + nums[index]);
        dfs(index + 1, cur - nums[index]);
    }*/

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        // 将剩下的分为一半进行抵消
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        // 挑选出  负数那部分
        int neg = diff / 2;

        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                // 只与上一轮有关。当前是不选nums[i]的种类数 + 选择nums[i]的种类数
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];

        /*int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                // 不选nums[i - 1]  就是上一回合的种类数
                dp[i][j] = dp[i - 1][j];
                // 加上选择nums[i - 1]  的种类数
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][neg];*/
    }
}
