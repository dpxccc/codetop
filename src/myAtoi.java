/**
 * @author diaopx
 * @date 2022/4/22 20:17
 * <p>
 * 8.字符串转换整数
 */
public class myAtoi {

    public static void main(String[] args) {
        myAtoi m = new myAtoi();
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(m.myAtoi("2147483648"));
    }

    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        // 去掉空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (n == index) {
            return 0;
        }
        // 正负数
        int flag = 1;
        if (s.charAt(index) == '-') {
            flag = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        int ans = 0;
        while (index < n) {
            char ch = s.charAt(index);
            // 不是数字
            if (!Character.isDigit(ch)) {
                return ans * flag;
            }
            // 越界
            if ((ans * 10 + ch - '0') / 10 != ans) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + ch - '0';
            index++;
        }
        return ans * flag;
    }
}
