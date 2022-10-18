import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/18 15:47
 *
 * 223.数字1的个数
 **/
public class countDigitOne {

    char[] s;
    int[][] dp;

    public int countDigitOne(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        // dp[i][j]表示 填充第i位时，已经有j个1的情况下 后续填数时1的总数
        dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, true, false);
    }

    public int dfs(int i, int preNum, boolean isLimit, boolean hasNum) {
        if (i == s.length) return hasNum ? preNum : 0;
        if (!isLimit && hasNum && dp[i][preNum] != -1) return dp[i][preNum];
        int res = 0;
        // 当前位置不选值  构建位数小的 数
        if (!hasNum) res = dfs(i + 1, 0, false, false);
        // 能够取得的上界
        int up = isLimit ? s[i] - '0' : 9;
        for (int k = hasNum ? 0 : 1; k <= up; k++) {
            // 此时取1 下一轮的preNum就多了1
            if (k == 1) {
                res += dfs(i + 1, preNum + 1, isLimit && k == up, true);
            } else {
                res += dfs(i + 1, preNum, isLimit && k == up, true);
            }
        }
        if (!isLimit && hasNum) dp[i][preNum] = res;
        return res;
    }
}
