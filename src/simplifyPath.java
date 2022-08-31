import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/8/31 14:54
 * <p>
 * 71.简化路径
 **/
public class simplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals(".")) {
                continue;
            } else if (arr[i].equals("..")) {
                // 到上一级（如果有的话）
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(arr[i]);
            }
        }
        // 使用stack时能够直接join
//        return "/" + String.join("/", stack);
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
