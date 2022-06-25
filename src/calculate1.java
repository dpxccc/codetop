import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/6/25 14:54
 * <p>
 * 224. 基本计算器
 **/
public class calculate1 {

    public int calculate(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int ans = 0;
        // 表示每个括号前应该是什么符号
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '+') {
                // + 和括号前应该的符号一致
                sign = ops.peek();
            } else if (ch == '-') {
                sign = -ops.peek();
            } else if (ch == '(') {
                // 保存括号内数字  外层的符号  括号内会相应的修改符号
                // 比如-(+ - )   外层-   内层碰到+  则变为外层的   碰到-  则需要变号
                ops.push(sign);
            } else if (ch == ')') {
                // 本层括号结束计算
                ops.pop();
            } else {
                long num = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                // 最终值 加上  本次的数（用符号 * 绝对值）
                ans += sign * num;
            }
        }
        return ans;
    }

    // 使用 map 维护一个运算符优先级
    // 这里的优先级划分按照「数学」进行划分即可
    Map<Character, Integer> map = new HashMap<>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate2(String s) {
        s = s.replace(" ", "");
        char[] array = s.toCharArray();
        int n = s.length();
        // 存放数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 防止第一个数是负数 先加个0
        nums.addLast(0);
        // 存放操作符
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = array[i];
            // 左括号直接加入
            if (ch == '(') {
                ops.addLast(ch);
                // 右括号则遍历到 第一个左括号
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(ch)) {
                    int u = 0;
                    int j = i;
                    while (j < n && Character.isDigit(array[j])){
                        u = u * 10 + (array[j++] - '0');
                    }
                    nums.addLast(u);
                    // 归位到最后一个数字，因为for最后要i++
                    i = j - 1;
                } else {
                    // 防止出现 +1  -2这种数
                    if (i > 0 && array[i - 1] == '(') {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(ch)) {
                            cal(nums, ops);
                        } else {
                            break;
                        }
                    }
                    // 操作完了不要忘了添加本次的运算符
                    ops.addLast(ch);
                }
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()) cal(nums, ops);
        return nums.peekLast();
    }

    public void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char ch = ops.pollLast();
        int result = 0;
        if (ch == '+') result = a + b;
        else if (ch == '-') result = a - b;
        else if (ch == '*') result = a * b;
        else if (ch == '/') result = a / b;
        else if (ch == '%') result = a % b;
        else if (ch == '^') result = (int) Math.pow(a, b);
        // 计算完之后再加入nums
        nums.addLast(result);
    }
}
