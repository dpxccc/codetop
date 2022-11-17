/**
 * @Author diaopx
 * @Date 2022/11/17 20:28
 *
 * 50 pow(x,n)
 **/
public class a50myPow {

    public double myPow1(double x, int n) {
        long p = n;
        if (p < 0) x = 1 / x;
        p = Math.abs(p);
        double ans = 1.0;
        while (p != 0) {
            if ((p & 1) == 1) {
                ans *= x;
            }
            x *= x;
            p >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long p = n;
        return n < 0 ? 1 / quickPow(x, -p) : quickPow(x, p);
    }

    public double quickPow(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickPow(x, n / 2);
        // 奇数的情况要多乘一下x
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
