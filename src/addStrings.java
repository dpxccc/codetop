/**
 * @author diaopx
 * @date 2022/4/15 10:15
 * <p>
 * 415.字符串相加
 */
public class addStrings {

    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        // 保存进位
        int carry = 0;
        int len = Math.max(m, n);
        for (int i = 0; i < len; i++) {
            // 先加上num1的值  超过位数了则是补0
            carry += i < m ? (num1.charAt(m - 1 - i) - '0') : 0;
            // 加上num2的值
            carry += i < n ? (num2.charAt(n - 1 - i) - '0') : 0;
            // 超过10了则保留余数
            sb.append(carry % 10);
            // 剩下的是进位
            carry /= 10;
        }
        // 需要判断最后一次的进位是否存在  例如 1 ， 9
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
