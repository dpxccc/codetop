/**
 * @author diaopx
 * @date 2022/5/6 10:10
 * <p>
 * 153.寻找旋转排序数组中的最小值
 */
public class findMin {

    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果当前nums[mid] > nums[right] 说明小区间在右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // nums[mid] < nums[right] 说明已经在小区间内，往左边找
                right = mid;
            }
        }
        return nums[left];
    }


    // 找最大值
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 跟左边进行比较，找到最大值
            int mid = (left + right + 1) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left == nums.length - 1 ? nums[0] : nums[left + 1];
    }
}
