/**
 * @Author diaopx
 * @Date 2022/7/29 13:03
 *
 * 940.不同子序列II
 **/
public class distinctSubseqII {

    // 从前往后之后 再从后往前遍历，dp[i]记录 以某个字母为结尾 加上该字符 能够组成的子序列个数（这个字母不是特定位置的，是表示整个s中所有的该字母结尾）
    // a b c b  dp就是1 2 4 8（b位置更新为8，包含了第一个以b结尾的子序列个数2,以第二个b为结尾能够组成该6个不同的）
    public int distinctSubseqII(String s) {
        int MOD = (int) (1e9 + 7);
        long[] dp = new long[26];
        for (int i = 0; i < s.length(); i++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum += dp[j];
                sum %= MOD;
            }
            // 因为可以把26个字母结尾的子序列的末尾加上该字符，就能得到不同的序列了，但是这样每个子序列的长度都是大于1的，然后再加上这个字符本身。
            // 包括 前面已经有一个单独b  组成bb，但是没了单独的b
            dp[s.charAt(i) - 'a'] = sum + 1;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}
