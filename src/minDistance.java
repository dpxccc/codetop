/**
 * @author diaopx
 * @date 2022/5/15 16:06
 * <p>
 * 72.编辑距离
 */
public class minDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // 初试状态
        // word1 的 i 个 变成 0 个的次数
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // word1 的 0 个 变成 i 个的次数
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前位置相同，不操作，就是前面i-2 和 j-2之间的操作次数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // word1 删除一个元素，word1添加一个元素，word1 替换元素
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
