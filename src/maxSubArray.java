/**
 * @author diaopx
 * @date 2022/4/5 19:29
 * <p>
 * 53.最大子数组和
 */
public class maxSubArray {

    /*public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp 表示以 表示以 nums[i] 结尾 的 连续 子数组的最大和
        int[] dp = new int[n];
        dp[0] = nums[0];
        // 如果 dp[i - 1] > 0，那么可以把 nums[i] 直接接在 dp[i - 1] 表示的那个数组的后面，得到和更大的连续子数组；
        //如果 dp[i - 1] <= 0，那么 nums[i] 加上前面的数 dp[i - 1] 以后值不会变大。于是 dp[i] 「另起炉灶」，此时单独的一个 nums[i] 的值，就是 dp[i]
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }*/

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            // preSum是大于0的就 对后面的有益， 小于等于0 则说明无用，选择nums[i]
            preSum = Math.max(preSum + nums[i], nums[i]);
            ans = Math.max(ans, preSum);
        }
        return ans;
    }


//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        int preSum = nums[0];
//        for (int i = 0; i < n; i++) {
//            if (preSum < 0) {
//                preSum = nums[i];
//            } else {
//                preSum += nums[i];
//            }
//            ans = Math.max(ans, preSum);
//        }
//        return ans;
//    }
}
