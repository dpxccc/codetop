import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/7 9:25
 *
 * 354.俄罗斯套娃信封问题
 **/
public class maxEnvelopes {

    /**
     * 排序后宽度已经是升序了，这时只要找到高度的最长自增子序列
     * 如果在宽度相同时 高度也是升序，可能会重复计算
     * [1,1] [2,2] [3,3] [3,4]  这样的话dp中就是 1,2,3,4
     * [1,1] [2,2] [3,4] [3,3]  dp中的数就是 1,2,4 -> 1,2,3
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 宽度升序，相同时  高度降序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[n];
        int len = 0;
        for (int[] en : envelopes) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (en[1] > dp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = en[1];
            if (len == left) len++;
        }
        return len;
    }

    /*public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] dp = new int[n][2];
        int len = 0;
        for (int[] en : envelopes) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (en[0] > dp[mid][0] && en[1] > dp[mid][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left][0] = en[0];
            dp[left][1] = en[1];
            if (len == left) len++;
        }
        return len;
    }*/

    // 普通动规超时
/*    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ans = 0;
        // dp[i]表示 以i为底能够放多少个
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int wi = envelopes[i][0], hi = envelopes[i][1];
            // 最长递增子序列
            for (int j = 0; j < i; j++) {
                if (wi > envelopes[j][0] && hi > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }*/
}
