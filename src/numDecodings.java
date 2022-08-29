/**
 * @Author diaopx
 * @Date 2022/8/29 19:23
 * <p>
 * 91.解码方法
 **/
public class numDecodings {

    public static void main(String[] args) {
        numDecodings n = new numDecodings();
        System.out.println(n.numDecodings("0"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        // dp[i]表示以 i-1 为结尾时的个数
        int[] dp = new int[n + 1];
        // 空字符串
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 先算单个的情况下
            if (ch != '0') {
                dp[i + 1] += dp[i];
            }
            // 算两个连在一起的时候  存在两个数  并且 首位不能是0，数字不能大过26
            if (i > 0 && s.charAt(i - 1) > '0' && ((s.charAt(i - 1) - '0') * 10 + ch - '0') <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
}
