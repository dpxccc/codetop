import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/22 21:09
 * <p>
 * 225.用队列实现栈
 */
public class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        // 将后加入的放在队列头
        int size = queue.size();
        // 先加入x
        queue.offer(x);
        // 然后将之前的数添加到后面
        for (int i = 0; i < size; i++) {
            queue.offer(queue.peek());
            queue.poll();
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
