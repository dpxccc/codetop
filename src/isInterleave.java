import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author diaopx
 * @Date 2022/9/17 10:05
 **/
public class isInterleave {

    // 滚动数组
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                // 这儿是将 s1和s3比  dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                // 也就是二维数组的上一行
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                // 这儿是将s2和s3比   dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                // 二维数组的左边一列  ||是因为 刚刚已经更新过一次了，取两个之间的真值
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[n];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m == 0) {
            return s2.equals(s3);
        }
        if (n == 0) {
            return s1.equals(s3);
        }
        if (m + n != k) return false;
        // dp[i][j]表示s1中0- i-1 和 s2中0- j-1中  能否组成s3中0- i+j-1
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // s1 取空时
        for (int i = 1; i <= n; i++) {
            dp[0][i] = (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        // s2 取空时
        for (int i = 1; i <= m; i++) {
            dp[i][0] = (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // s1和s3相同时，则要求前面的也能够匹配，s2和s3时一样
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }


    // 表示 s1是x，s2在y时，匹配的是s3的z时 是否满足条件
    int[][][] map;

    public boolean isInterleave1(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m == 0) {
            return s2.equals(s3);
        }
        if (n == 0) {
            return s1.equals(s3);
        }
        if (m + n != k) return false;
        map = new int[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(map[i][j], -1);
            }
        }
        return dfs(s1, s2, s3, 0, 0, 0);
    }

    public boolean dfs(String s1, String s2, String s3, int x, int y, int z) {
        // if ((z == s3.length() && x == s1.length()) || (z == s3.length() && y == s2.length())) {
        //     map[x][y][z] = 1;
        //     return true;
        // }
        if (z == s3.length()) {
            map[x][y][z] = 1;
            return true;
        }
        // 不能在 x == s1.length() 时返回，因为可能s2还能匹配，只是s1已经匹配完了
        if (x > s1.length() || y > s2.length()) return false;
        if (x < s1.length() && y < s2.length() && map[x][y][z] != -1) {
            return map[x][y][z] == 1;
        }
        if (x < s1.length() && s1.charAt(x) == s3.charAt(z) && dfs(s1, s2, s3, x + 1, y, z + 1)) {
            map[x][y][z] = 1;
            return true;
        }
        if (y < s2.length() && s2.charAt(y) == s3.charAt(z) && dfs(s1, s2, s3, x, y + 1, z + 1)) {
            map[x][y][z] = 1;
            return true;
        }
        map[x][y][z] = 0;
        return false;
    }
}
