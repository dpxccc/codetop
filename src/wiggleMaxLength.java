/**
 * @Author diaopx
 * @Date 2022/9/5 21:00
 * <p>
 * 376.摆动排序
 **/
public class wiggleMaxLength {

    /*
        设dp状态dp[i][0]，表示考虑前i个数，第i个数作为山峰的摆动子序列的最长长度
        设dp状态dp[i][1]，表示考虑前i个数，第i个数作为山谷的摆动子序列的最长长度

        dp[i][0] = max(dp[i][0], dp[j][1] + 1)，其中0 < j < i且nums[j] < nums[i]，
        表示将nums[i]接到前面某个山谷后   面，作为山峰。

        dp[i][1] = max(dp[i][1], dp[j][0] + 1)，其中0 < j < i且nums[j] > nums[i]，
        表示将nums[i]接到前面某个山峰后面，作为山谷。
    */
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        // 初始状态
        dp[0][1] = 1;
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            //每一层的初始状态  自身
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                //山谷
                if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    //优化的动态规划   up 和 down 分别表示山峰和山谷
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                // up = Math.max(up, down + 1);  山峰时在前面山谷的基础上+1
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                // down = Math.max(up + 1, down);
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }


}


