/**
 * @Author diaopx
 * @Date 2022/10/26 16:19
 *
 * 188.买卖股票的最佳时机IIII
 **/
public class maxProfitIIII {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 类似于 3 的求解方式，在上一次的基础上进行买卖
        // dp[i][0] 表示第i次购买
        int[][] dp = new int[k][2];
        // 初始化。k次交易的情况
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            // k=0次的情况
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                // 在 上一次售出的情况下购买
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                // 本次情况下进行售出
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k - 1][1];
    }
}
