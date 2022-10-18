import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/18 16:46
 * <p>
 * 600.不含连续1的非负整数
 **/
public class findIntegers {

    char[] s;
    int[][] dp;

    public int findIntegers(int n) {
        // 转化为二进制
        s = Integer.toBinaryString(n).toCharArray();
        int m = s.length;
        // 第i位及后面 包含的方案数
        dp = new int[m][2];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, false, true);
    }

    // 前导0不影响结果，所以可以不需要hasNum
    public int dfs(int i, boolean pre1, boolean isLimit) {
        // 能够组成一个满足条件的数
        if (i == s.length) return 1;
        if (!isLimit && dp[i][pre1 ? 1 : 0] != -1) return dp[i][pre1 ? 1 : 0];
        int res = 0;
        // 能取的上界
        int up = isLimit ? s[i] - '0' : 1;
        // 不管上个二进制是0还是1，这一位都可以填0
        res += dfs(i + 1, false, isLimit && up == 0); // 填0
        // 只有上一位是0的时候才能填1，并且up 要等于 1  填1的时候 只需要判断前面是不是isLimit
        if (up == 1 && !pre1) {
            res += dfs(i + 1, true, isLimit);
        }
        if (!isLimit) dp[i][pre1 ? 1 : 0] = res;
        return res;
    }
}
