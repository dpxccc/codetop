import java.util.PriorityQueue;

/**
 * @author diaopx
 * @date 2022/4/30 22:43
 * <p>
 * 2233.K次增加后的最大乘积
 */
public class maximumProduct {

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (k != 0) {
            int tmp = pq.poll();
            pq.offer(tmp + 1);
            k--;
        }
        int ans = 1;
        while (!pq.isEmpty()) {
            ans = ans * pq.poll() % 1000000007;
        }
        return ans % 100000007;
    }
}
