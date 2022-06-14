import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/6/14 11:34
 *
 * 739.每日温度
 **/
public class dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 栈中记录前面温度最大的 下标
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // 碰到更大的  则将小的出栈
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 获得下标
                int j = stack.pop();
                // 差距就是两者的距离
                ans[j] = i - j;
            }
            stack.push(i);
        }
        return ans;
    }
}
