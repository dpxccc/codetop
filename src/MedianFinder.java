import java.util.PriorityQueue;

/**
 * @Author diaopx
 * @Date 2022/10/6 10:22
 *
 * 295.数据流的中位数
 **/
public class MedianFinder {

    // min 是小于等于中位数的优先队列
    PriorityQueue<Integer> min;
    // max 是大于中位数的优先队列
    PriorityQueue<Integer> max;

    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 如果min是空的   或者   num 小于等于 min的最大值（min的大根堆）
        if (min.isEmpty() || num <= min.peek()) {
            min.add(num);
            // 如果min的大小超过了max的大小+1
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
        } else {
            max.offer(num);
            // 维持min的大小  大于等于 max的大小
            if (max.size() > min.size()) {
                min.add(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) * 0.5;
        } else {
            return min.peek();
        }
    }
}
