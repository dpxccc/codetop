/**
 * @author diaopx
 * @date 2022/4/23 10:36
 * <p>
 * 43.字符串相乘
 */
public class multiply {

    public static void main(String[] args) {
        multiply m = new multiply();
        System.out.println(m.multiply("2", "355555555555"));
    }


    /*    num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
        例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中*/
    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] mul = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int num = a * b;
                // 先加上低位  判断是否有进位
                num += mul[i + j + 1];
                mul[i + j + 1] = num % 10;
                mul[i + j] += num / 10;
            }
        }
        int index = 0;
        while (index < mul.length && mul[index] == 0) {
            index++;
        }
        while (index < mul.length) {
            sb.append(mul[index]);
            index++;
        }
        return sb.toString();

    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        if (num1.equals("0") || num2.equals("0")) {
            sb.append("0");
            return sb.toString();
        }
        for (int i = 0; i < n; i++) {
            int a = num2.charAt(n - 1 - i) - '0';
            StringBuilder tmp = new StringBuilder();
            int carry = 0;
            // 需要添加 0
            for (int k = 0; k < i; k++) {
                tmp.append("0");
            }
            // 将本次的计算结果放到tmp中，然后和上次的结果 sb  进行相加，并继续放到sb中
            for (int j = 0; j < m; j++) {
                int b = num1.charAt(m - 1 - j) - '0';
                carry += a * b;
                tmp.append(carry % 10);
                carry /= 10;
            }
            // 有多余的进位，则添加到tmp中
            if (carry > 0) {
                tmp.append(carry);
            }
            sb = plus(sb, tmp);
        }
        // 最后在翻转
        return sb.reverse().toString();
    }

    // 添加进来的是 最低位放在了最左边
    public StringBuilder plus(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int m = num1.length();
        int n = num2.length();
        if (m == 0) {
            return num2;
        }
        if (n == 0) {
            return num1;
        }
        for (int i = 0; i < Math.max(m, n); i++) {
            int a = i < m ? num1.charAt(i) - '0' : 0;
            int b = i < n ? num2.charAt(i) - '0' : 0;
            carry += a + b;
            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb;
    }


}
