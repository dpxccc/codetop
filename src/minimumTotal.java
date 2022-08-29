import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/8/29 20:42
 * <p>
 * 120.三角形最小路径和
 **/
public class minimumTotal {

    // 自底向上
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j]表示从点 (i, j) 到底边的最小路径和。
        // 多一行的话，不用特判最后一行了
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推
        for (int i = n - 1; i >= 0; i--) {
            // 遍历每一行
            for (int j = 0; j <= i; j++) {
                // dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // 自底向上 + 优化空间
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // n + 1 就可以不用特判最后一行 的 最后一个数需要加上 虚空的一个数
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            // 遍历每一行
            for (int j = 0; j <= i; j++) {
                // 计算 dp[i][j] 时，只用到了下一行的 dp[i + 1][j] 和 dp[i + 1][j + 1]
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
