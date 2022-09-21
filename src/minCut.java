import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/9/21 14:28
 * <p>
 * 132.分割字符串
 **/
public class minCut {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        // f[i]是s[0...i]之间的最小分割次数
        int[] f = new int[n];
        Arrays.fill(f, n - 1);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                // s[0..i]不是回文串，就找前面是回文串的地方 在多拆分一下
                for (int j = 0; j < i; j++) {
                    // 如果 s[j+1...i]是回文串 就是f[j] + 1 和 f[i]之间取最小值
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
