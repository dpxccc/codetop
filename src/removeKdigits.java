import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/7/28 9:25
 * <p>
 * 402.移掉k位数字
 **/
public class removeKdigits {

    // 单调栈
    // 基本思想是，把前面的大数删除
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            // 将前面的大数弹出
            while (!stack.isEmpty() && k > 0 && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // 可能是按顺序的，则把后面的弹出
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 然后逆序
        sb.reverse();
        int index = 0, len = sb.length();
        while (index < len && sb.charAt(index) == '0') {
            index++;
        }
        if (index != 0) {
            sb.delete(0, index);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
