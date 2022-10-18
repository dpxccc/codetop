import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/18 17:23
 * <p>
 * 1012.至少有1为重复的数字
 **/
public class numDupDigitsAtMostN {

    char[] s;
    int[][][] dp;

    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        // mask和 有没有重复选  作为状态量
        dp = new int[m][1 << 10][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << 10); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(0, 0, true, false, false);
    }

    public int dfs(int i, int mask, boolean isLimit, boolean hasNum, boolean isRepeat) {
        if (i == s.length) return hasNum && isRepeat ? 1 : 0;
        if (!isLimit && hasNum && dp[i][mask][isRepeat ? 1 : 0] != -1) return dp[i][mask][isRepeat ? 1 : 0];
        int res = 0;
        if (!hasNum) res = dfs(i + 1, mask, false, false, false);
        int up = isLimit ? s[i] - '0' : 9;
        for (int k = hasNum ? 0 : 1; k <= up; k++) {
            res += dfs(i + 1, mask | (1 << k), isLimit && k == up, true, isRepeat | ((mask >> k) & 1) == 1);
            //    if (((mask >> k) & 1) == 0) {
            //        res += dfs(i + 1, mask | (1 << k), isLimit && k == up, true, isRepeat);
            //    } else {
            //        res += dfs(i + 1, mask, isLimit && k == up, true, true);
            //    }
        }
        if (!isLimit && hasNum) dp[i][mask][isRepeat ? 1 : 0] = res;
        return res;
    }

/*    char[] s;
    int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, true, false, false);
    }

    public int dfs(int i, int mask, boolean isLimit, boolean hasNum, boolean isRepeat) {
        if (i == s.length) return hasNum && isRepeat ? 1 : 0;
        if (!isLimit && hasNum && dp[i][mask] != -1) return dp[i][mask];
        int res = 0;
        if (!hasNum) res = dfs(i + 1, mask, false, false, false);
        int up = isLimit ? s[i] - '0' : 9;
        for (int k = hasNum ? 0 : 1; k <= up; k++) {
            res += dfs(i + 1, mask | (1 << k), isLimit && k == up, true, isRepeat | ((mask >> k) & 1) == 1);

        }
        // 只有没有约束条件  并且满足重复条件的情况下 才记忆，少了isRepeat 记忆的数会少情况
        if (!isLimit && hasNum && isRepeat) dp[i][mask] = res;
        return res;
    }*/
}
