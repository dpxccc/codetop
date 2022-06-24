import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/6/24 14:43
 * <p>
 * 16.最接近的三数之和
 **/
public class threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            // 固定一个值  然后降重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            // 双指针  找最接近的
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                    // 降重
                    while (left < right && nums[right] == nums[right + 1])  right--;
                } else {
                    left++;
                    // 降重
                    while (left < right && nums[left] == nums[left - 1])    left++;
                }
            }
        }
        return ans;
    }
}
