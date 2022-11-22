/**
 * @Author diaopx
 * @Date 2022/11/21 21:13
 * <p>
 * 1201。丑数III
 **/
public class nthUglyNumber {

    // 对于i来说，能够整除a的有i/a个  对于abc的最小公倍数中有多少个需要的
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // ABC的公共最小公倍数
        long lcmABC = lcm(lcmAB, c);
        long left = Math.min(a, Math.min(b ,c)), right = (long) n * left;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 求1-mid之间满足要求的个数  需要减去 ab，ac，bc的公倍数个数，不过在减去前面的时候已经减了3次abc的公倍数
            long cnt = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcmABC;
            if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
        // 确定 1-lcmAB 之间满足要求的个数
//        long m = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + 1;
    }

    public long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
}
