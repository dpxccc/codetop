/**
 * @Author diaopx
 * @Date 2022/11/30 10:30
 *
 * 877.石子游戏
 **/
public class a877stoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] 表示 剩余i - j 这堆时 当前和另一个的差值
        int[][] dp = new int[n][n];
        // 初始化 只剩一堆时 差值为pile[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // ij 可以由 i+1 - j选i得到   也可以由 i - j-1选j得到
                // 选上当前值之后 - 前面玩家和自己的差值 = 当前玩家和另一个的差值
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        // 0 - n-1 的差值大于0 代表a赢
        return dp[0][n - 1] > 0;
    }
}
