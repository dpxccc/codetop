/**
 * @author diaopx
 * @date 2022/5/23 14:55
 * <p>
 * 74.搜索二维矩阵
 */
public class searchMatrix {


    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return matrix[low / n][low % n] == target;
    }
}
