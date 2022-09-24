import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/9/24 18:09
 **/
public class insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int lindex = -1, rindex = -1;
        int left = newInterval[0], right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        int i = 0;
        // 找到第一个 右边界 > left的区间
        while (i < m && left > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }
        // 合并新区间，如果newInterval和别的区间没有重叠，则不会进入这个while
        while (i < m && right >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while (i < m) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
