/**
 * @ClassName minFlipsMonoIncr
 * @Author diaopx
 * @Date 2022/6/10 15:37
 *
 * 926.将字符串翻转到单调递增
 **/
public class minFlipsMonoIncr {

    /**
     * 因为该次的结果都和上次的有关  则可以用两个变量记录上次的结果
     */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int one = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                one = Math.min(zero, one) + 1;
            } else {
                // 先赋值one，否则zero会被覆盖
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(one, zero);
    }

    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        // dp[i][0] 表示当前位置为改为0的步数   dp[i][1]表示当前位置改为1的步数
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                // 当前位置是 改为0 则是上一次也是0
                dp[i][0] = dp[i - 1][0];
                // 改为1  则是上一次的最小 + 1
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                // 改变则是上一次的 + 1
                dp[i][0] = dp[i - 1][0] + 1;
                // 不变则是上一次的最小值
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
