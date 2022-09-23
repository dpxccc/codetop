/**
 * @Author diaopx
 * @Date 2022/9/23 9:42
 * <p>
 * 圆环回到原点
 **/
public class backToOrigin {
    public static void main(String[] args) {
        backToOrigin b = new backToOrigin();
        System.out.println(b.backToOrigin(2));
    }

    int mod = (int) (1e9 + 7);

    public int backToOrigin(int n) {
        // dp[i][j]表示 走了i步到j的方案数
        int[][] dp = new int[n + 1][10];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = (dp[i - 1][(j + 1) % 10] + dp[i - 1][(j - 1 + 10) % 10]) % mod;
            }
        }
        return dp[n][0] % mod;
    }
}
