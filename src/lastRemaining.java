/**
 * @author diaopx
 * @date 2022/5/14 21:32
 * <p>
 * 剑指offer 62.圆圈中最后剩下的数字
 */
public class lastRemaining {

    // 约瑟夫环   关注下标
    public int lastRemaining1(int n, int m) {
        int k = 0;
        for (int i = 2; i <= n; i++) {
            k = (k + m) % i;
        }
        return k;
    }

    public int lastRemaining(int n, int m) {
        if (n == 0) {
            return 0;
        }
        return (m + lastRemaining(n - 1, m)) % n;
    }
}
