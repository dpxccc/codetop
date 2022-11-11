import java.util.HashMap;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/11/11 15:02
 * <p>
 * 659.分割数组为连续子序列
 **/
public class a659isPossible {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> tail = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int x = cnt.get(num);
            if (x == 0) continue;
            else if (tail.getOrDefault(num - 1, 0) > 0) {
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
                cnt.put(num, x - 1);
            } else if (cnt.getOrDefault(num + 1, 0) > 0 && cnt.getOrDefault(num + 2, 0) > 0) {
                cnt.put(num, x - 1);
                cnt.put(num + 1, cnt.get(num + 1) - 1);
                cnt.put(num + 2, cnt.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
