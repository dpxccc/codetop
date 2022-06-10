import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/3/30 16:37
 * <p>
 * 695.岛屿的最大面积
 */
public class maxAreaOfIsland {


    /*int m, n;
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) {
            return 0;
        }
        // 计数记为 1，dfs计算周围的数量
        int count = 1;
        grid[x][y] = 0;
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            count += dfs(grid, nx, ny);
        }
        return count;
    }*/

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        // 记录横纵坐标
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遇到 1 则ans++，并加入队列把周围的 1 都置为 0
                if (grid[i][j] == 1) {
                    int count = 0;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        count++;
                        int[] tmp = queue.poll();
                        int x = tmp[0], y = tmp[1];
                        // 当出队时标记为 0 ，写在这儿会导致重复入队，有很多会重复遍历
                        // grid[x][y] = 0;
                        // 遍历周围节点
                        for (int[] d : dir) {
                            int nx = x + d[0], ny = y + d[1];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                            queue.offer(new int[]{nx, ny});
                            // **********在入队时就置为0，标记为访问过，防止后面重复入队。
                            grid[nx][ny] = 0;
                        }
                    }
                    ans = Math.max(ans, count);
//                    System.out.println(ans);
                }
            }
        }
        return ans;
    }
}
