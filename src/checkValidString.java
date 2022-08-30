import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/8/30 20:51
 *
 * 678.有效的括号字符串
 **/
public class checkValidString {

    public boolean checkValidString(String s) {
        // 左括号 和 星号的下标
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else {
                // 优先匹配左括号
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        // 右括号已经全部匹配，现在把左括号全部匹配  并且需要左括号的下标在左边
        while (!left.isEmpty() && !star.isEmpty() && left.peek() < star.peek()) {
            left.pop();
            star.pop();
        }
        if (!left.isEmpty()) {
            return false;
        }
        return true;
    }
}
