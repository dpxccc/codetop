/**
 * @author diaopx
 * @date 2022/5/2 14:43
 * <p>
 * 213.打家劫舍II、
 */
public class rob {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robAction(nums, 0, n - 1), robAction(nums, 1, n));
    }

    public int robAction(int[] nums, int i, int j) {
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[i];
        dp[1] = Math.max(dp[0], nums[i + 1]);
        // a 跟踪dp的下标，k是nums的下标
        int a = 2;
        for (int k = i + 2; k < j; k++, a++) {
            dp[a] = Math.max(dp[a - 1], dp[a - 2] + nums[k]);
        }
        return dp[dp.length - 1];
    }
}
