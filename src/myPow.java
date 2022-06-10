/**
 * @author diaopx
 * @date 2022/5/31 14:59
 * <p>
 * 50.Pow(x,n)
 */
public class myPow {

    public double myPow1(double x, int n) {
        double ans = 1;
        long p = n;
        if (n < 0) {
            p = -p;
        }
        while (p > 0) {
            // 对应的n的二进制位是1的话  就需要进行连乘，否则就直接进行乘方次数的保存
            // 如果 p 二进制表示的最低位为 1，那么需要计入贡献
            if ((p & 1) != 0) {
                ans *= x;
            }
            //不停的叠加  下一次的乘方次数
            x *= x;
            //右移一位，也就是除以2
            p >>= 1;
        }
        return n < 0 ? 1 / ans : ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        // 奇数要多乘x
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
