/**
 * @Author diaopx
 * @Date 2022/12/22 11:15
 * <p>
 * 526.优美的排列
 **/
public class a526countArrangement {
    public static void main(String[] args) {
        a526countArrangement a526countArrangement = new a526countArrangement();
        System.out.println(a526countArrangement.countArrangement(5));
    }

    public int countArrangement(int n) {
        int mask = 1 << n;
        // dp[i][j]表示前 i个数   当前的选择方案为j的情况 的方案数
        int[][] dp = new int[n + 1][mask];
        dp[0][0] = 1;
        // 遍历前i个数   情况
        for (int i = 1; i < n + 1; i++) {
            // 枚举对n=i的所有状态下的方案数
            for (int j = 0; j < mask; j++) {
                // 选择i个数的情况下  所以mask的选择情况（即1的bit位数）也应该是i
                // 不加这个判断也是可以的，对于不是  其他cnt的mask，因为一开始  获得的都是0
                // 比如说  i=1，mask=(11)2 = 3，  对于(10) (01) 都满足，但是i=0是都是0，所以后续获取也是0
                int cnt = Integer.bitCount(j);
                if (cnt != i) continue;
                // 遍历当前状态中 1，当前选择 k - 1位 ，k-1位则为1，这种情况下的最大值
                // k从1开始是因为  题目的序号从1开始
                for (int k = 1; k <= n; k++) {
                    // 第k-1位为0则跳过
                    if (((j >> (k - 1)) & 1) == 0) continue;
                    if (k % i != 0 && i % k != 0) continue;
                    // dp[i][j] 的方案数， j的1状态选择下的前一次的所有次数
                    // 上一次的 k-1位置零   就是  左移k-1位，取反   那一位就置零了
                    dp[i][j] += dp[i - 1][j & (~(1 << k - 1))];
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < mask; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n][mask - 1];
    }
}
