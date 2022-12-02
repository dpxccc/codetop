/**
 * @Author diaopx
 * @Date 2022/12/2 16:28
 *
 * 167.两数之和II  输入有序数组
 **/
public class a167twoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] ans = new int[2];
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, 1 + right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
