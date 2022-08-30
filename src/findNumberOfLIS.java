import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/8/30 15:06
 *
 * 673.最长递增子序列个数
 **/
public class findNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的最大长度
        int[] dp = new int[n];
        // count[i] 表示以nums[i]结尾的最大长度的组合个数
        int[] count = new int[n];
        // 最大长度最起码是1
        int max = 1;
        int res = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 只有在当前数比前面数大的时候才需要进行判断
                if (nums[i] > nums[j]) {
                    // 比较当前的dp[i] 和 dp[j]加上nums[i]组成的最大长度
                    // 如果+1长于当前LIS 则组合数不变  就是count[j]的组合 最后加个nums[i]
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        // 这种情况是 当前的长度 和 前面某个位置 +1 的长度相等，说明找到了新的组合
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        for (int i = 0; i < n; i++) {
            if (max == dp[i]) {
                res += count[i];
            }
        }
        return res;
    }
}
