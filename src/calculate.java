import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/5/9 11:31
 * <p>
 * 227.基本计算器II
 */
public class calculate {

    public static void main(String[] args) {
        calculate calculate = new calculate();
        System.out.println(calculate.calculate(" 3/2 "));
    }

    public int calculate1(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int digit = 0;
        // 保存上一个符号
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            }
            // 不能直接else   因为可能该数字在字符串的最后
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                // 因为碰到了下一个 符号，所以可以当前记录着该次的digit  可以计算上一个的算术
                switch (sign) {
                    case '+':
                        stack.push(digit);
                        break;
                    case '-':
                        // 取反  入栈
                        stack.push(-1 * digit);
                        break;
                    case '*':
                        // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                        stack.push(stack.pop() * digit);
                        break;
                    case '/':
                        stack.push(stack.pop() / digit);
                        break;
                }
                // 记录当前的符号
                sign = s.charAt(i);
                // 清零
                digit = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
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

    public int calculate(String s) {
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 存放所有「非数字以外」的操作
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && Character.isDigit(cs[j])) u = u * 10 + (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    // 多判断了前面是否是 + -   是多判断了 +-  不作为算术符号   而是正负
                    // 加0  是为了方便计算  在一开始的时候就是符号的话
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        else if (op == '/') ans = a / b;
        else if (op == '^') ans = (int) Math.pow(a, b);
        else if (op == '%') ans = a % b;
        nums.addLast(ans);
    }


}
