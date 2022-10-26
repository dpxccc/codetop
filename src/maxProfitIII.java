/**
 * @Author diaopx
 * @Date 2022/10/26 14:30
 *
 * 123.买卖股票的最佳时机III
 **/
public class maxProfitIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j][k] 表示对第i只股票，当前持不持有股票，以及已经购买了k次
        int[][][] dp = new int[n][2][3];
        // 初始化 第0天的时候 持有和不持有其实与交易次数无关
        for (int i = 0; i < 3; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }
        // 按照天数 和 交易次数遍历
        for (int i = 1; i < n; i++) {
            // 持有股票0次交易的时候   不持有股票也没交易过的话是0
            dp[i][0][0] = 0;
            // 上一次持有股票0次交易   或者  上一次不持有股票0次交易
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j < 3; j++) {
                // 当前不持有股票 j次交易 = 上次不持有股票j次交易 或者 上次持有股票有j-1次交易，这次卖了
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                // 当前持有股票 j次交易 = 上次持有股票j次交易 或者 上次不持有股票j次交易，这次买了股票
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }
        // 当前没有股票并且卖了2次
        return dp[n - 1][0][2];
    }


    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        // 在第一次卖出的基础上再买
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        // 如果最优的情况对应的是恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，从 sell1 转移到 sell2，最终答案是sell2
        return sell2;
    }
}
