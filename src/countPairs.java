import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/9/24 21:38
 * <p>
 * 2316.统计无向图中无法互相到达点对数
 **/
public class countPairs {

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public long getSum() {
            long ans = 0L;
            int n = parent.length;
            for (int i = 0; i < n; i++) {
                if (i == parent[i]) {
                    System.out.println(i + "====" + size[i]);
                    ans += size[i] * 1L * (n - size[i]);
                }
            }
            return ans / 2;
        }
    }

    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.getSum();
    }
}
