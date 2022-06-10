import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/5/6 11:01
 * <p>
 * 394.字符串解码
 */
public class decodeString {

    public String decodeString(String s) {
        // 记录数字
        Deque<Integer> stackCount = new ArrayDeque<>();
        // 记录字母，并且记录着前一次的sb
        Deque<String> stackSb = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 在最开始的时候会压入一个空的 sb
            if (ch == '[') {
                // 将保存的数字和res压入栈
                stackCount.push(digit);
                stackSb.push(res.toString());
                // 重置
                digit = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                // 循环次数
                int count = stackCount.pop();
                // 之前的sb   res是记录着这一次的sb，没入栈
                StringBuilder temp = new StringBuilder(stackSb.pop());
                for (int j = 0; j < count; j++) {
                    temp.append(res);
                }
                // 将遍历到现在的总和sb 赋值给res，如果后续继续存在[ 则可以继续将res入栈
                res = temp;
            } else if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }


    // 递归
    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    // 返回的数组中包括 返回的字符串 和  遍历的位置
    public String[] dfs(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            } else if (ch == '[') {
                // 获得后续的sb
                String[] tmp = dfs(s, i + 1);
                // 将刚刚递归遍历的最终位置获得 ，更新 i 的位置
                i = Integer.parseInt(tmp[1]);
                while (digit > 0) {
                    sb.append(tmp[0]);
                    digit--;
                }
            } else if (ch == ']') {
                return new String[]{sb.toString(), String.valueOf(i)};
            } else {
                sb.append(ch);
            }
        }
        return new String[]{sb.toString()};
    }
}
