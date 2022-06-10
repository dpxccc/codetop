/**
 * @author diaopx
 * @date 2022/5/12 19:40
 * <p>
 * 647.回文子串
 */
public class countSubstrings {

    public int countSubstrings1(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += expand(s, i, i);
            ans += expand(s, i, i + 1);
        }
        return ans;
    }

    public int expand(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            ans++;
        }
        return ans;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    ans++;
                    dp[i][j] = true;
                }
            }
        }
        return ans;
    }
}
