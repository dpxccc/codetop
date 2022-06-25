import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/6/25 11:21
 * <p>
 * 剑指offer 61 扑克牌中的顺子
 **/
public class isStraight {


    public boolean isStraight(int[] nums) {
        int max = 0, min = 14;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                if (set.contains(nums[i])) return false;
                set.add(nums[i]);
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
        }
        return (max - min) < 5;
    }

    public boolean isStraight1(int[] nums) {
        int zero = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                // 0的数量
                zero++;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                return false;
            } else if (i > 0 && nums[i - 1] != 0) {
                // 需要补的差值，0 的数量小于0了，则false
                zero -= (nums[i] - nums[i - 1] - 1);
                if (zero < 0) {
                    return false;
                }
            }
        }
        return zero >= 0;
    }


}
