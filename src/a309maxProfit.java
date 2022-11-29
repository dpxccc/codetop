/**
 * @Author diaopx
 * @Date 2022/11/29 16:04
 *
 * 309.最佳买卖股票时机含冷冻期
 **/
public class a309maxProfit {
    // 买入的时候不能从dp[][1] 状态得到，因为前一天刚卖，今天是冷冻期，要买入只能从 第3状态得到，前一天不操作，后一天肯定不是冷冻期。
    // 三个状态  1.买入股票  2.不持有股票，今天之后处于冷冻期状态 3.不持有股票，也不买股票，今天之后肯定不是冷冻期
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 这个是今天必须持有  并且是今天卖掉  然后进入冷冻期
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 当天不持有股票，今天可能是冷冻期，也可能不是，但是后一天肯定不是冷冻期，  前一天不持有股票 或者 前一天卖了股票
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
