/**
 * @author diaopx
 * @date 2022/5/13 10:56
 *
 * 516.最长回文子序列
 */
public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 首尾相同，取中间的最大长度  及时是相邻的两个  dp[1][2] = dp[2][1] + 2  下三角dp[2][1] = 0
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 不相同时，取这次遍历没包含自身 或者 上次遍历包含自身的最大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
