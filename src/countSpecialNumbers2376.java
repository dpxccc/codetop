import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/18 12:12
 *
 * 2376.统计特殊整数
 **/
public class countSpecialNumbers2376 {

    char[] s;
    int[][] dp;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        // dp[i][mask]记录当前选择顺位为i，已选状态为mask时，构造第i位及后面位的合法方案数   1<<10 用二进制表示 0-9 种取值
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            // 初始化dp为-1,表示还未进行计算
            Arrays.fill(dp[i], -1);
        }
        // 注意一开始最高位是有限制的，isLimit=true  如果不设置为true，那么最高位取值会取到9
        return dfs(0, 0, true, false);
    }

    // dfs(i, mask, isLimit, hasNum) 代表从左到右选第i个数字时，前面已选状态为mask时的合法方案数
    public int dfs(int i, int mask, boolean isLimit, boolean hasNum) {
        // base case  选过数则算1个，全0不算
        if (i == s.length) return hasNum ? 1 : 0;
        // !isLimit表示没有被限制的才可以直接得出结果，有约束的情况下，可能还有别的子情况没考虑
        if (!isLimit && hasNum && dp[i][mask] != -1) return dp[i][mask];
        int res = 0;
        // 本位什么都不取，考虑 位数较小的情况   如果前面已经取过数了，则hasNum是true，这个位置必须要选数，不能跳过
        if (!hasNum) res = dfs(i + 1, mask, false, false);
        // 能取的最大值
        int up = isLimit ? s[i] - '0' : 9;
        // 能取的最小值   前面有数的话  这儿能从0开始，否则只能取1开始
        int k = hasNum ? 0 : 1;
        for (; k <= up; k++) {
            // 如果该数字k还没有被选中，那猫就可以选该位数字
            if (((mask >> k) & 1) == 0) {
                // 方案数遵循加法原理
                // i:进行下一位的DFS，因此为i+1
                // mask:由于该位选中了k，mask需要更新，已选状态加上k
                // isLimit:当且仅当前面的被限制了且该位被限制
                // hasNum:该位选了必定为true
                res += dfs(i + 1, mask | (1 << k), isLimit && k == up, true);
            }
        }
        // 如果前面没有限制，表明后面都是同质的
        // 为什么只记忆!isLimit && hasNum 这两种状态下的  例如  n=123  你一直都是limit状态下取值的话，那么不会有重复的情况  不会有第二次回溯到这种情况  hasNum一样，前面不取值也是只出现一次
        if (!isLimit && hasNum) dp[i][mask] = res;
        return res;
    }
}
