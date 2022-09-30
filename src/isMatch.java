/**
 * @Author diaopx
 * @Date 2022/9/30 12:19
 *
 * 10.正则表达式匹配
 **/
public class isMatch {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // s 和 p都是空串时 匹配
        dp[0][0] = true;
        // s 是空串时，看p是否含有*
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);
                // 两个相同  或者  p对应的是 .  这时就看前面的是否符合
                if (ch1 == ch2 || ch2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch2 == '*') {
                    // p 是 * 时 需要考虑多个情况
                    // 1.* 前面的字符 能够和 ch1匹配
                    if (p.charAt(j - 2) == ch1 || p.charAt(j - 2) == '.') {
                        // * 匹配0次  或者 * 匹配1次(a,a  匹配完后就可以把a 和 a*豆产区) 或者 匹配多次  例： a  和  aaa（a*重复三次）  后面匹配的还是同一个字符a
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] ||dp[i - 1][j];
                    } else {
                        // 2. *前面的字符和 ch1不匹配  *匹配0次
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
