import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/9/4 15:48
 * <p>
 * 239.滑动窗口的最大值
 **/
public class maxSlidingWindow {

    public static void main(String[] args) {
        maxSlidingWindow m = new maxSlidingWindow();
        System.out.println(m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 存储的是最大值的下标
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;
        while (right < n) {
            // 维护一个 递减的队列
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(right);
            if (right - left >= k) {
                // 超过窗口时，判断删除的左边界是不是最大值
                if (left == deque.peekFirst()) {
                    deque.pollFirst();
                }
                left++;
            }
            if (right >= k - 1) {
                // 获得此时的最大值
                ans[right - k + 1] = nums[deque.peekFirst()];
            }
            right++;
        }
        return ans;
    }
}
