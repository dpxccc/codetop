import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author diaopx
 * @date 2022/4/14 10:17
 * <p>
 * 232.用栈实现队列
 */
public class MyQueue {

    // stack1是工作栈   stack2是辅助栈
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
