import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/17 11:16
 * <p>
 * 56.合并区间
 */
public class merge {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][2];
        }
        // 保存最后的左右位置
        List<int[]> list = new ArrayList<>();
        // 对intervals根据左边界排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            // 当前的左右边界
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 加入的最后数组 左右边界
            int L = list.get(list.size() - 1)[0];
            int R = list.get(list.size() - 1)[1];
            // list中的右边界 小于 当前的 left  则直接加入
            if (R < left) {
                list.add(intervals[i]);
            } else {
                // 修改右边界 取最大
                list.get(list.size() - 1)[1] = Math.max(R, right);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][2];
        }
        // 保存最后的左右位置
        List<int[]> list = new ArrayList<>();
        // 对intervals根据左边界排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ) {
            // 当前的左右边界
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 从下一个开始找合并的最大区间
            int j = i + 1;
            while (j < n && intervals[j][0] <= right) {
                right = Math.max(right, intervals[j][1]);
                j++;
            }
            list.add(new int[]{left, right});
            i = j;
        }
        return list.toArray(new int[list.size()][]);
    }
}
