import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/3/29 14:12
 * <p>
 * 200.岛屿数量
 */
public class numIslands {

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    /*int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int ans = 0;
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到1，这说明这块区域存在岛屿，把这块区域全部变成0
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] d : dir) {
            int nx = i + d[0], ny = j + d[1];
            dfs(grid, nx, ny);
        }

    }*/
    public int numIslands(char[][] grid) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        // 记录横纵坐标
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遇到 1 则ans++，并加入队列把周围的 1 都置为 0
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int x = tmp[0], y = tmp[1];
                        // 当出队时标记为 0 ，写在这儿会导致重复入队，有很多会重复遍历
                        // grid[x][y] = '0';
                        // 遍历周围节点
                        for (int[] d : dir) {
                            int nx = x + d[0], ny = y + d[1];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '0') continue;
                            queue.offer(new int[]{nx,ny});
                            // **********在入队时就置为0，标记为访问过，防止后面重复入队。
                            grid[nx][ny] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
