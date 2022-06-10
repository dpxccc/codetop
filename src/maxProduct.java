/**
 * @author diaopx
 * @date 2022/5/8 15:41
 * <p>
 * 152.乘积最大子数组
 */
public class maxProduct {

    /**
     * 同时维护 以 nums[i]为结尾的最大值和最小值
     * 最大值需要尽可能的大，最小值尽可能小
     * max = max * n[i], min * n[i], n[i]
     * min = min * n[i], max * n[i], n[i]
     */
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // 遇到负数时，可能乘以最小值可以获得最大
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));

            ans = Math.max(max[i], ans);
        }
        return ans;
    }

    // 压缩空间
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int maxPre = nums[0];
        int minPre = nums[0];
        for (int i = 1; i < n; i++) {
            // 缓存一下，否则在求minPre时 maxPre已经被覆盖了
            int mx = maxPre, mn = minPre;
            maxPre = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minPre = Math.min(mx * nums[i], Math.min(mn * nums[i], nums[i]));

            ans = Math.max(maxPre, ans);
        }
        return ans;
    }
}
