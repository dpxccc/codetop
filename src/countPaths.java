import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author diaopx
 * @Date 2022/11/26 10:42
 * <p>
 * 1976.到达目的地的方案数
 **/
public class countPaths {

    public int countPaths(int n, int[][] roads) {
        int mod = (int) (1e9 + 7);
        List<int[]>[] path = new List[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        // 建图
        for (int[] road : roads) {
            int x = road[0], y = road[1], t = road[2];
            path[x].add(new int[]{y, t});
            path[y].add(new int[]{x, t});
        }
        // Dijkstra
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        int[] cnt = new int[n];
        cnt[0] = 1;
        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            int x = (int) poll[0];
            long t = poll[1];
            if (t > dist[x]) continue;
            for (int[] next : path[x]) {
                int y = next[0];
                long newTime = t + next[1];
                // 入队列  并且计算到每个位置 time最小时的 种类数
                if (newTime < dist[y]) {
                    dist[y] = newTime;
                    pq.offer(new long[]{y, newTime});
                    cnt[y] = cnt[x] % mod;
                } else if (newTime == dist[y]) {
                    cnt[y] = (cnt[y] + cnt[x]) % mod;
                }
            }
        }
        return cnt[n - 1];
    }
}
