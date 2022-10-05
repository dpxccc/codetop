import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/10/5 9:41
 *
 * 32.最长有效括号
 **/
public class longestValidParentheses {

    /*public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }
        int ans = 0;
        // dp[i]表示 以i结尾的最长有效括号长度
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            // 碰到 (  肯定是0
            if (s.charAt(i) == ')') {
                // 前一个是 ( ，那么就能组成一个有效括号，长度关键是看 i-2的长度
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (s.charAt(i - 1) == ')') {
                    int len = dp[i - 1];
                    // 如果还有多的长度能够判断的话
                    if (i - len >= 1) {
                        // 并且中间长度的前一个是 (
                        if (s.charAt(i - len - 1) == '(') {
                            // 如果和 ((  (()())   假设(()())匹配了，但是前面还有两个((可能匹配，所以需要 加上 以被匹配的( 前一位 为结尾的最大长度
                            dp[i] = dp[i - 1] + 2 + ((i - len - 2 >= 1) ? dp[i - len - 2] : 0);
                        }
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }*/

    /*public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        // 栈底 存放的是  最后一个没有被匹配的右括号的下标
        Deque<Integer> stack = new ArrayDeque<>();
        // 处理边界条件  第一个就是(  导致栈底不是右括号
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                // 最低部的右括号出栈了，没有左括号能够匹配，那么就更新为新的 最后一个没有被匹配的右括号
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }*/

    /**
     * 贪心
     * 左右遍历两次，  左边遍历时  left 和 right记录两个数量，相等时就更新ans，left<right时就重新开始计数
     * 这样会漏了一种情况(()  永远无法相等。所以可以反向遍历
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else right++;
            if (left == right) {
                // 更新ans
                ans = Math.max(ans, left);
            } else if (right > left) {
                // 重新计数
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        // 反向
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else right++;
            if (left == right) {
                // 更新ans
                ans = Math.max(ans, left);
            } else if (left > right) {
                // 重新计数
                left = 0;
                right = 0;
            }
        }
        // ans记录的组数  最后要*2
        return ans * 2;
    }
}
