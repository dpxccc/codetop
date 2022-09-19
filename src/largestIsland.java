import java.util.HashSet;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/9/18 8:45
 * <p>
 * 827.人工岛
 **/
public class largestIsland {

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dirs[k][0], nj = j + dirs[k][1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1 && visited[ni][nj] == 0) {
                            uf.union(i * n + j, ni * n + nj);
                            visited[ni][nj] = 1;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 保存i j周围四个节点的根节点
                Set<Integer> set = new HashSet<>();
                // 计算本次的面积大小
                int curSize = 0;
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dirs[k][0], nj = j + dirs[k][1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int root = uf.find(ni * n + nj);
                            if (!set.contains(root)) {
                                curSize += uf.getSize(root);
                                set.add(root);
                            }
                        }
                    }
                    // +1 是0变成1
                    curSize++;
                } else {
                    // 是1的话就计算覆盖区域的大小
                    int root = uf.find(i * n + j);
                    curSize = uf.getSize(i * n + j);
                }
                ans = Math.max(ans, curSize);
            }
        }
        return ans;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int[][] grid;

        public UnionFind(int[][] grid) {
            int n = grid.length * grid[0].length;
            this.grid = grid;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parents[x]) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parents[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int getSize(int x) {
            x = find(x);
            return size[x];
        }
    }
}
