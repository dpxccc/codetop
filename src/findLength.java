/**
 * @author diaopx
 * @date 2022/4/29 9:08
 * <p>
 * 718.最长重复子数组
 */
public class findLength {

    /**
     * 动态规划
     */
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前位相同时 获取前面的最长相同子数组长度 + 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (ans < dp[i][j]) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * 滚动数组
     */
    public int findLength3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }


    // 滑动窗口
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        // 先让nums1的开头 依次 匹配nums2的每个数
        for (int i = 0; i < n; i++) {
            // 获取匹配的数组的长度
            int len = Math.min(m, n - i);
            if (len <= ans) break;
            int maxLen = getMaxLen(nums1, nums2, 0, i, len);
            ans = Math.max(ans, maxLen);
        }

        // 让num2的开头 依次 匹配nums1的每个数
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            if (len <= ans) break;
            int maxLen = getMaxLen(nums1, nums2, i, 0, len);
            ans = Math.max(maxLen, ans);
        }
        return ans;
    }

    /**
     * 获取根据该遍历头实现的  本次遍历的最大值
     *
     * @param nums1  数组1
     * @param nums2  数组2
     * @param start1 数组1 匹配开始的位置
     * @param start2 数组2 匹配开始的位置
     * @param len    两个数组匹配的长度
     * @return 返回相同子数组的最大长度
     */
    private int getMaxLen(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int ret = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }
}
