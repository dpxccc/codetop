import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/6/16 12:40
 *
 * 560.和为k的子数组
 **/
public class subarraySum {

    /**
     扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
     **/
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 单个0  是有时候会有一个数就满足条件的子数组
        map.put(0, 1);
        int sum = 0, ret = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ret += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
