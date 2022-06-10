import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/5/7 10:23
 * <p>
 * 442.数组中重复的数据
 */
public class findDuplicates {

    // 数组中的元素都是1-n的话，那么一般可以把它们当做下标，然后进行相应位置 +n
    public List<Integer> findDuplicates1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 因为相应的位置可能已经加过n，会数组越界
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 如果有下标对应的数已经 大于 2*n，说明数组中的对应下标的数 超过两个
            if (nums[i] > 2 * n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 相同位置已经变换过一次了，那么就加入ans，没变过则 将相应位置变为相反数
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            } else {
                ans.add(x);
            }
        }
        return ans;
    }
}
