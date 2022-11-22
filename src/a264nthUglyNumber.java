/**
 * @Author diaopx
 * @Date 2022/11/22 9:35
 *
 * 264.丑数II
 **/
public class a264nthUglyNumber {

    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int[] dp = new int[n + 1];
        // 1 默认是丑数  并且从1开始
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int x2 = 2 * dp[p2], x3 = 3 * dp[p3], x5 = 5 * dp[p5];
            dp[i] = Math.min(x2, Math.min(x3, x5));
            if (x2 == dp[i]) p2++;
            if (x3 == dp[i]) p3++;
            if (x5 == dp[i]) p5++;
        }
        return dp[n];
    }
}
