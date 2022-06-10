/**
 * @author diaopx
 * @date 2022/4/1 20:05
 * <p>
 * 5.最长回文子串
 */
public class longestPalindrome {

    /*public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        int n = s.length();
        // dp[i][j]的含义为  下标 i 到 j的最长子串长度
        boolean[][] dp = new boolean[n][n];
        // 反向查找
        for (int i = n - 1; i >= 0; i--) {
            // 初始化每个字符长度为1
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                if (flag && j - i > 1) {
                    // 两边相等，关键看中间的i+1  -  j-1之间是不是回文串
                    //不是相邻的元素相同，这时需要判断中间两元素之间 字符串是不是回文
                    //例如babad     在判断aba时， 两个a不相邻,这时需要只需要判断两个a之间的b是否是回文串
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    //其他情况包括相邻相同，相邻不相同和没有相同元素
                    dp[i][j] = flag;
                }

                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }*/

    public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n < 1) {
            return "";
        }
        int start = 0;
        int maxLen = 0;
        // 中心扩展
        for (int i = 0; i < n; i++) {
            // 两种扩散，一种同一点，一种两个相邻端点
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
