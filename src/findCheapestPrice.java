import java.util.*;

/**
 * @Author diaopx
 * @Date 2022/10/26 19:28
 * <p>
 * 787.K站中转内最便宜的航班
 **/
public class findCheapestPrice {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 中转站有k个 那么加上起始 终点站 一共有k+2个站   dp[i][j]表示到达第i站 经过j站 的price
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < k + 2; i++) {
            dp[src][i] = 0;
        }
        for (int i = 1; i < k + 2; i++) {
            for (int[] f : flights) {
                // 如果上一轮的f[0]已经经历过  则该轮能够到达end = f[1]
                if (dp[f[0]][i - 1] != Integer.MAX_VALUE) {
                    dp[f[1]][i] = Math.min(dp[f[0]][i - 1] + f[2], dp[f[1]][i]);
                }
            }
        }
        return dp[dst][k + 1] == Integer.MAX_VALUE ? -1 : dp[dst][k + 1];
    }


    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] path = new List[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        for (int[] f : flights) {
            path[f[0]].add(new int[]{f[1], f[2]});
        }
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        // <start, prices>
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
        // 小于等于k，因为从src开始会多计算一个，中转站的个数是k
        while (!queue.isEmpty() && cnt <= k) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int start = arr[0], total = arr[1];
                for (int[] d : path[start]) {
                    int end = d[0], p = d[1];
                    // 如果当前的目标是dst，则判断ans
                    if (end == dst) {
                        ans = Math.min(ans, total + p);
                    } else if (total + p < price[end]) {
                        // 如果不是dst，则判断当前的是否访问过，并且这次到end的price是否更小，小则加入，否则就跳过
                        queue.offer(new int[]{end, total + p});
                        price[end] = total + p;
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
