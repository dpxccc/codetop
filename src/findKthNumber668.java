/**
 * @author diaopx
 * @date 2022/5/18 9:54
 *
 * 668.乘法表中第k小的数
 */
public class findKthNumber668 {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            // 前面x/n（向下取整）行的个数，这几行的数都是小于 x的，其实也就是i*n <= x的个数  x/n就是行数
            // 也可以在下面的for循环中一起处理，找到每一行min(x/i,n)
            int count = x / n * n;
            // 求得之后每一行的 小于 x 的个数累加，每一行是递增的，并且都是i的倍数，这些中存在大于x的数
            // 例如 m = 3，n = 3。 x = 5 默认5/3*3 个。然后第2、3行--> 5/2个 和 5/3个
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if (count < k) {
                left = x + 1;
            } else {
                right = x;
            }
        }
        return left;
    }
}
