/**
 * @Author diaopx
 * @Date 2022/8/29 20:21
 **/
public class rotate189 {

    // 先整体翻转，然后把前半部分翻转 和 后半部分翻转
    // 12345 -> 54321 -> 45123
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
