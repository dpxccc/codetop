/**
 * @Author diaopx
 * @Date 2022/6/14 9:44
 *
 * 498.对角线遍历
 **/
public class findDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int x = 0, y = 0;
        // 另外向上或者向下的if和else if 的顺序不能弄反了（考虑正方形对角线情况）
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[x][y];
            // 判断进行遍历的是哪一个对角线  为偶数为从 左下 往 右上
            if ((x + y) % 2 == 0) {
                // 先判断这个边界条件，在对角线的时候需要先进行边界的判断，否则先判断x == 0 会越界。如果先到了右边界，则向下移一格，下一步 向左下遍历
                if(y == n - 1) {
                    x++;
                } else if (x == 0) {
                    // 右移一格
                    y++;
                } else {
                    // 向上移动
                    x--;
                    y++;
                }
            } else {
                // 对角线要注意  到底边 右移
                if (x == m - 1) {
                    y++;
                } else if (y == 0) {
                    // 到左边界  下移
                    x++;
                } else {
                    // 向左下
                    x++;
                    y--;
                }
            }
        }
        return res;
    }
}
