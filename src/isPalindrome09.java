/**
 * @author diaopx
 * @date 2022/4/30 10:52
 *
 * 9.回文数
 */
public class isPalindrome09 {

    public boolean isPalindrome(int x) {
        int val = 0;
        int tmp = x;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            if (val > (Integer.MAX_VALUE - x % 10) / 10) {
                return false;
            }
            val = val * 10 + x % 10;
            x /= 10;
        }
        return val == tmp;
    }
}
