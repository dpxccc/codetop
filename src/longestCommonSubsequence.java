/**
 * @author diaopx
 * @date 2022/4/1 21:47
 * <p>
 * 1143.最长公共子序列
 */
public class longestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp[i][j]表示 text1 中0 - (i-1)  和 text2中 0 - (j - 1)相同序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char temp1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char temp2 = text2.charAt(j - 1);
                // 相等时，就是前 text1中i-1段  和  text2中j-1段 的相同子序列长度  +  1
                if (temp1 == temp2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // i-1 和 j 与  i段和j-1段 之间取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
