import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author diaopx
 * @Date 2022/11/26 10:00
 *
 * 743.网络延迟时间
 **/
public class networkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] path = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            path[i] = new ArrayList<>();
        }
        // 构建邻接表
        for (int[] t : times) {
            int x = t[0], y = t[1], c = t[2];
            path[x].add(new int[]{y, c});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int x = poll[0], t = poll[1];
            // 如果碰到了比之前算的结果大的情况就跳过
            if (t > dist[x]) continue;
            for (int[] next : path[x]) {
                int y = next[0], cost = next[1];
                int newDist = t + cost;
                if (newDist < dist[y]) {
                    dist[y] = newDist;
                    pq.offer(new int[]{y, newDist});
                }
            }
        }
        int ans = 0;
        // n从1开始
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
