/**
 * @author diaopx
 * @date 2022/5/14 19:36
 * <p>
 * 剑指offer 21 调整数组顺序使奇数位于偶数之前
 */
public class exchange {

    public int[] exchange(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            // 左边跳过奇数，找到第一个偶数
            while (left <= right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left <= right && ((nums[right] & 1) == 0)) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
