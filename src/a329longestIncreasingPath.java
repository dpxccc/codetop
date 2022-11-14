/**
 * @Author diaopx
 * @Date 2022/11/14 14:41
 * <p>
 * 329.矩阵中的最长递增路径
 **/
public class a329longestIncreasingPath {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 表示当前位置出发能够最远的地方
    int[][] map;
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        map = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, map[i][j]);
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int x, int y) {
        // 访问过了
        if (map[x][y] != 0) return map[x][y];
        map[x][y] = 1;
        int[] arr = new int[4];
        for (int i = 0; i < dirs.length; i++) {
            int nx = x + dirs[i][0], ny = y + dirs[i][1];
            // 越界或者当前的数大于等于下一个数
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[x][y]) continue;
            arr[i] = dfs(matrix, nx, ny);
        }
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, arr[i]);
        }
        map[x][y] += max;
        return map[x][y];
    }
}
