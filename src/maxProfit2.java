/**
 * @author diaopx
 * @date 2022/3/31 14:56
 * <p>
 * 122.买卖股票的最佳时机II
 */
public class maxProfit2 {

    // price[i]更小，则更新min，否则先卖出（ans += prices[i] - min），然后更新min，
    // 1,2,4,3,6    1-2-4  依次卖出，然后min=4，更新为3,3-6卖出。
    // 中间有波动 和 从最小到最大相比，波动内部计算大
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            // 只要后一天比前一天大 就把这两天的差值加一下
            if (prices[i] >= min) {
                ans += prices[i] - min;
            }
            min = prices[i];
        }
        return ans;
    }

//    扫描一遍 只要后一天比前一天大 就把这两天的差值加一下
    /*public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }*/

    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]  表示第i天持有现金
        // dp[i][1]  表示第i天持有股票
        int[][] dp = new int[n][2];
        // 第一天持有现金,不持有股票
        dp[0][0] = 0;
        // 第一天持有股票  ，即买入
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i-1][0] 昨天持有现金，不动
            // dp[i-1][1] 昨天持有股票，今天卖出，收入现金prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i-1][1] 昨天持有股票，不动
            // dp[i-1][0] 昨天持有现金，今天买入，减少现金prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }*/
}
