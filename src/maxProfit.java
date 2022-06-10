/**
 * @author diaopx
 * @date 2022/3/31 14:05
 * <p>
 * 121.买卖股票的最佳时机
 */
public class maxProfit {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        // 碰到小的则更新最小值，碰到大的则计算能够获得的最大收益
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                ans = Math.max(prices[i] - min, ans);
            }
        }
        return ans;
    }
}
