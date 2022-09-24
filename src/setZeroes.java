/**
 * @Author diaopx
 * @Date 2022/9/24 17:04
 *
 * 73.矩阵置零
 **/
public class setZeroes {

    // 根据第一行、第一列来置0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        // 判断第一行是否有0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        // 判断第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        // 从除了第一行，第一列的矩阵中找到0，然后在第一行第一列进行标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 再根据第一行和第一列的0，将其他地方置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 再将 第一行和第一列置零
        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
