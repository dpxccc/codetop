/**
 * @Author diaopx
 * @Date 2022/6/20 15:20
 * <p>
 * 剑指offer 29.顺时针打印矩阵
 **/
public class spiralOrderjianzhi {


    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int id = 0;
        int x = 0, y = 0;
        for (int i = 0; i < m * n; i++) {
            ans[i] = matrix[x][y];
            visited[x][y] = true;
            // 下一次的坐标
            int nx = x + dir[id][0], ny = y + dir[id][1];
            // 判断坐标是否满足要求
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                id = (id + 1) % 4;
            }
            // 下一次应该的坐标
            x = x + dir[id][0];
            y = y + dir[id][1];
        }
        return ans;

    }


    public int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int[] ans = new int[m * n];
        int idx = 0;
        while (left <= right && top <= bottom) {
            // 先 left - right
            for (int i = left; i <= right; i++) {
                ans[idx++] = matrix[top][i];
            }
            top++;
            if (top > bottom) break;
            // top - bottom
            for (int i = top; i <= bottom; i++) {
                ans[idx++] = matrix[i][right];
            }
            right--;
            if (left > right) break;
            // right - left
            for (int i = right; i >= left; i--) {
                ans[idx++] = matrix[bottom][i];
            }
            bottom--;
            // bottom - top
            for (int i = bottom; i >= top; i--) {
                ans[idx++] = matrix[i][left];
            }
            left++;
        }
        return ans;
    }
}
