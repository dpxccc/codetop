/**
 * @author diaopx
 * @date 2022/4/29 11:12
 * <p>
 * 64.最小路径和
 */
public class minPathSum {

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 记录到每个位置的最短距离
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 该点只能从左边和上边得到，取两者的最小值
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        // 先构建第一行
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            // 找到每一行的开始
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                // 然后该行的其余位置 从左边和上一边（上一轮） 取小
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
