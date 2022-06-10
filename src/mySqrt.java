/**
 * @author diaopx
 * @date 2022/4/18 10:33
 * <p>
 * 69.x的平方根
 */
public class mySqrt {

    public static void main(String[] args) {
        mySqrt m = new mySqrt();
        System.out.println(m.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (long)left * left == x ? left : left - 1;
    }
}
