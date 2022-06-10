import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author diaopx
 * @date 2022/5/5 12:19
 * <p>
 * 128.最长连续序列
 */
public class longestConsecutive {


    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                // 该位置的最长序列长度为 左侧的最长距离 + 右侧的最长距离 + 自身1个
                int sum = left + right + 1;
                ans = Math.max(ans, sum);
                map.put(num, sum);
                // 修改两个边界的值，是这一段序列的最长距离
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return ans;
    }

    public int longestConsecutive2(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // set会去重，减少遍历的个数
        for (int num : set) {
            int x = num;
            // 从最底部开始往上找，x为当前位置的最底部
            if (!set.contains(x - 1)) {
                int sum = 1;
                while (set.contains(x + 1)) {
                    x++;
                    sum++;
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
