import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/3/28 15:43
 * <p>
 * 18.四数之和
 */
public class fourSum {

    /**
     *  此题类似于三数之和，固定两个位置，然后双指针移动，根据sum与target的大小比较，移动left或者right
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                // 排除相同的情况
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 双指针
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
