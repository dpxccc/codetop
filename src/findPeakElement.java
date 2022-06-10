/**
 * @author diaopx
 * @date 2022/4/21 16:18
 * <p>
 * 162.寻找峰值
 */
public class findPeakElement {

    // 规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
    // 规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        // 找到最大值
        int idx = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
