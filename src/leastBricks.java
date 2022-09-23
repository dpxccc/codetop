import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/9/23 10:04
 * <p>
 * 554 砖墙
 **/
public class leastBricks {

    // 找空隙的个数
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return wall.size() - max;
    }
}
