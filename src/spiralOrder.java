import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/15 14:25
 * <p>
 * 54.螺旋矩阵
 */
public class spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 左右边界
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> ans = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 先遍历top   left - right之间的值
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // 此时top已经大于bottom时，直接跳出，防止下面 right - left 横向出现重复计算
            if (top > bottom) break;
            // right 中  top - bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // right小于left时直接跳出。防止下面bottom - top 纵向出现重复计算
            if (right < left) break;
            // bottom 中 right - left
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            // left 中 bottom — top
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
