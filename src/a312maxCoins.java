/**
 * @Author diaopx
 * @Date 2022/11/30 14:31
 *
 * 312.戳气球
 **/
public class a312maxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        // dp[i][j] 表示 i-j（开区间）之间的最大硬币数dp[i][j] = d[i][k] + d[k][j] + arr[i]*arr[j]*arr[k]
        // i-j之间只剩k没有戳破
        int[][] dp = new int[n + 2][n + 2];
        // 先遍历len  长度大的需要长度小的得到
        for (int len = 3; len < n + 2; len++) {
            // 枚举左边界
            for (int i = 0; i + len - 1 < n + 2; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[j] * arr[k]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
