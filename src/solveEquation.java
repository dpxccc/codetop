/**
 * @Author diaopx
 * @Date 2022/10/29 14:23
 *
 * 640.求解方程
 **/
public class solveEquation {

    public String solveEquation(String equation) {
        String[] arr = equation.split("=");
        int[] left = getCnt(arr[0]);
        int[] right = getCnt(arr[1]);
        if (left[0] == right[0]) {
            if (left[1] != right[1]) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        }
        System.out.println(left[0] + "    " + left[1]);
        System.out.println(right[0] + "    " + right[1]);
        int ans = (right[1] - left[1]) / (left[0] - right[0]);
        return "x=" + ans;
    }


    // res[0]是x的系数，res[1]是常数
    public int[] getCnt(String s) {
        int n = s.length();
        // 符号
        int sign = 1;
        int digit = 0;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            } else if (ch == 'x') {
                if (i == 0 || !Character.isDigit(s.charAt(i - 1))) {
                    res[0] += sign;
                }
                res[0] += sign * digit;
                digit = 0;
                sign = 1;
            } else if (ch == '+') {
                // 求取上一次的符号
                res[1] += digit * sign;
                digit = 0;
                // 下一次的符号为正
                sign = 1;
            } else if (ch == '-') {
                res[1] += digit * sign;
                digit = 0;
                sign = -1;
            }
        }
        if (digit != 0) {
            res[1] += digit * sign;
        }
        return res;
    }
}
