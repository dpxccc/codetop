import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author diaopx
 * @date 2022/5/14 18:28
 * <p>
 * 剑指offer 40 最小的k个数
 */
public class getLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }


    public int[] getLeastNumbers1(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int index = randomPartition(arr, left, right);
            if (index == k - 1) {
                return Arrays.copyOfRange(arr, 0, k);
            } else if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    private int randomPartition(int[] arr, int left, int right) {
        Random random = new Random();
        // 包含left 和 right
        int index = random.nextInt(right - left + 1) + left;
        // 将基准值交换到最后
        swap(arr, index, right);
        // 基准值
        int pivot = arr[right];
        int i = left;
        // 将小于pivot的值放到前面
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        // 返回分隔位置
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
