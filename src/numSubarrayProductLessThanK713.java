/**
 * @author diaopx
 * @date 2022/5/19 20:34
 * <p>
 * 713.乘积小于k的子数组
 */
public class numSubarrayProductLessThanK713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int num = 1;
        int ans = 0;
        while (right < n && left <= right) {
            num *= nums[right];
            while (num >= k && left <= right) {
                num /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
