import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/12/2 16:37
 *
 * 763.划分字母区间
 **/
public class a763partitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[] map = new int[26];
        // 记录字母最后的位置
        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        int max = -1;
        int left = -1;
        for (int i = 0; i < n; i++) {
            // 不停地更新这个区间的最大索引
            max = Math.max(max, map[s.charAt(i) - 'a']);
            // 最大索引就是当前位置时   可以拆分
            if (max == i) {
                ans.add(i - left);
                left = i;
            }
        }
        return ans;
    }
}
