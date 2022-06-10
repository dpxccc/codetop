import java.util.PriorityQueue;

/**
 * @author diaopx
 * @date 2022/5/17 21:25
 * <p>
 * 378.有序矩阵中第K小的元素
 */
public class kthSmallest378 {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int left = matrix[0][0], right = matrix[m - 1][m - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k, m)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算整个矩阵中 小于等于mid 的个数
     */
    private boolean check(int[][] matrix, int mid, int k, int m) {
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < m) {
            if (mid < matrix[i][j]) {
                // 这一行不满足条件了
                i--;
            } else {
                // 这儿 mid >= matrix[i][j] 则说明这一列都满足条件，这一列的个数是i+1个
                count += i + 1;
                // 往后移一位
                j++;
            }
        }
        return count < k;
    }


    // k路合并
    public int kthSmallest1(int[][] matrix, int k) {
        int m = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 将每一行的第一个数字加入pq  后续查找删除的是第几行的数字，然后将改行的后面一个数加入pq
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        // 前k-1个
        while (--k > 0) {
            int[] tmp = pq.poll();
            int row = tmp[1];
            int column = tmp[2];
            if (column != m - 1) {
                pq.offer(new int[]{matrix[row][column + 1], row, column + 1});
            }
        }
        return pq.poll()[0];
    }
}
