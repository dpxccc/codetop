import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author diaopx
 * @date 2022/3/28 10:00
 * <p>
 * 215.数组中的第K个最大元素
 */
public class findKthLargest {

    /**
     * 快排解法
     */
    int[] nums;
    int k;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int index = randomPartition(left, right);
            if (index == n - k) {
                return nums[index];
            } else if (index < n - k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return 0;
    }

    public int randomPartition(int left, int right) {
        Random random = new Random();
        // 包含left 和 right
        int index = left + random.nextInt(right - left + 1);
        // 将基准值放到最后
        swap(index, right);
        // 基准值
        int pivot = nums[right];
        // i记录左边能够交换的位置，双指针
        int i = left;
        // 将小于pivot的值都放到左边
        for (int j = left; j <= right - 1; j++) {
            if (nums[j] <= pivot) {
                swap(i, j);
                i++;
            }
        }
        // 将pivot交换到中间
        swap(i, right);
        // 返回分割位置
        return i;
    }


    public void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 解法二：用小根堆，heap中的数量超过k个数时，就poll出，剩下的k个数就是最小的k个
     *
     * @param nums
     * @param k
     * @return
     */
/*    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }*/

}
