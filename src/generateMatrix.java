/**
 * @author diaopx
 * @date 2022/5/2 16:03
 * <p>
 * 59.螺旋矩阵II
 */
public class generateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num;
                num++;
            }
            top++;
            // 此时top已经大于bottom时，直接跳出，防止下面 right - left 横向出现重复计算
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num;
                num++;
            }
            right--;
            // right小于left时直接跳出。防止下面bottom - top 纵向出现重复计算
            if (right < left) break;

            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num;
                num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num;
                num++;
            }
            left++;
        }
        return ans;
    }


    public int[][] generateMatrix1(int n) {
        int num = 1;
        // 右下左上
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[n][n];
        int dirIndex = 0;
        int column = 0, row = 0;
        while (num <= n * n) {
            ans[row][column] = num;
            num++;
            // 按当前方向继续下一个查询
            int nextRow = row + dirs[dirIndex][0];
            int nextColumn = column + dirs[dirIndex][1];
            // 不满足条件则换方向
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || ans[nextRow][nextColumn] != 0) {
                dirIndex = (dirIndex + 1) % 4;
            }
            // 换或者不换都是根据dirIndex 获得下一个位置
            row = row + dirs[dirIndex][0];
            column = column + dirs[dirIndex][1];
        }
        return ans;
    }
}
