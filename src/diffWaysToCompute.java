import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/7/1 9:53
 * <p>
 * 241.为运算表达式设计优先级
 **/
public class diffWaysToCompute {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        int len = expression.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // 出现运算符号，递归求解前半段和后半段。  获得左边 右边的可能情况
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                // 遍历左半部分 和 右半部分  组合起来
                for (int x : left) {
                    for (int y : right) {
                        switch (ch) {
                            case '+':
                                list.add(x + y);
                                break;
                            case '-':
                                list.add(x - y);
                                break;
                            case '*':
                                list.add(x * y);
                                break;
                        }
                    }
                }
            }
        }
        // 只有一个数字
        if (list.size() == 0) list.add(Integer.parseInt(expression));
        map.put(expression, list);
        return list;
    }
}
