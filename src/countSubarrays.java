import java.util.HashMap;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/11/27 15:38
 * <p>
 * 周赛321  第四题
 **/
public class countSubarrays {

    public int countSubarrays(int[] nums, int k) {
        int pos = 0;
        int n = nums.length;
        for (; pos < n; pos++) {
            if (nums[pos] == k) break;
        }
        // 记录k右边  大于k  和  小于k的情况
        Map<Integer, Integer> map = new HashMap<>();
        // *****左半部分 碰到0 和1的情况 会每次多加1，代表的当前情况的1*****
        map.put(0, 1);
        int sum = 0;
        for (int i = pos + 1; i < n; i++) {
            // 小于k 时置为-1
            sum += nums[i] < k ? -1 : 1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int ans = 0;
        // 直接加上 大于k 小于k 抵消的数量，和大于k多一个情况（偶数个，k在中间左边）
        ans += map.getOrDefault(0, 0) + map.getOrDefault(1, 0);
        // 计算k左边
        sum = 0;
        for (int i = pos - 1; i >= 0; i--) {
            // 小于k 时置为-1
            sum += nums[i] < k ? -1 : 1;
            // 同时计算ans  当前位置的数量为sum，右边对应的key为-sum   -sum+1（偶数情况）
            ans += map.getOrDefault(-sum, 0) + map.getOrDefault(-sum + 1, 0);
        }
        return ans;
    }
}
