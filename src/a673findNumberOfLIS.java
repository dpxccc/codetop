import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/11/17 18:56
 *
 * 673.最长递增子序列的个数
 **/
public class a673findNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的最大长度
        int[] dp = new int[n];
        // count[i] 表示以nums[i]结尾的最大长度的组合个数
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        // 最大长度
        int max = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 比较当前的dp[i] 和 dp[j]加上nums[i]组成的最大长度
                    // 如果+1长于当前LIS 则组合数不变  就是count[j]的组合 最后加个nums[i]
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        // 这种情况是 当前的长度 和 前面某个位置 +1 的长度相等
                        // 说明找到了新的组合方式，以nums[j] 和 nums[i]结尾的新的组合
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }
}
