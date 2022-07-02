import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author diaopx
 * @Date 2022/7/2 11:42
 *
 * 剑指offerII 42 最近请求次数
 **/
public class RecentCounter {

    Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
