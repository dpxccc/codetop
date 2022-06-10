import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/4/14 11:10
 * <p>
 * 155.最小栈
 */
public class MinStack {

    /*// 用一个辅助栈保存到此为止的最小值
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        // 插入最大值是为了方便插入第一个数时能够比较
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        // minStack中插入val 和 minStack 中的栈顶元素
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        // 同步弹出。将val和此时的最小值同步弹出
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }*/


    // 二元组 左边val  右边min
    Deque<int[]> stack = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int min = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, min)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
