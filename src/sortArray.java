import java.util.Random;

/**
 * @author diaopx
 * @date 2022/5/23 9:59
 * <p>
 * 912.排序数组
 */
public class sortArray {

    // 1.快排
    public int[] sortArray1(int[] nums) {
        int left = 0, right = nums.length - 1;
        randomQuicksort(nums, left, right);
        return nums;
    }

    private void randomQuicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomPartition(nums, left, right);
            randomQuicksort(nums, left, pos - 1);
            randomQuicksort(nums, pos + 1, right);
        }
    }


    public int randomPartition(int[] nums, int left, int right) {
        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left;
        int pivot = nums[index];
        // 将pivot交换到末尾
        swap(nums, index, right);
        int i = left;
        for (int j = left; j < right; j++) {
            // 将小于等于pivot的值交换到左边
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     *  堆排序  堆排序的思想就是先将待排序的序列建成大根堆，使得每个父节点的元素大于等于它的子节点。被交换的尾结点是必然比当前的孩子节点小
     *  第一步: 构建大顶堆
     *  第二步: 交换堆点元素(堆点元素与当前处理的二叉树最后一个元素交换)
     *  第三步: 去除二叉树最后一个节点, 对二叉树根节点堆化(heapify)
     *  第四步: 重复第二、第三步直至结束
     */
    public int[] sortArray2(int[] nums) {
        int lastIndex = nums.length - 1;
        // 构建大根堆之后 大的数都已在顶部，之后每次从0开始遍历
        buildMaxHeap(nums, lastIndex);
        // >= 1是需要将 0 和 1 交换  然后i-- 之后maxHeap(nums,0,0) 没有结果，也不用交换
        for (int i = lastIndex; i >= 1;) {
            swap(nums, i, 0);
            // 交换首尾后 最大索引减一
            i--;
            // 继续找最大值
            maxHeap(nums, 0, i);
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums, int lastIndex) {
        // 从最后一个节点的父节点 开始 从后往前遍历      使得所有的父节点大于孩子节点
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            maxHeap(nums, i, lastIndex);
        }
    }

    // lastIndex 是 当前遍历范围的最大索引
    private void maxHeap(int[] nums, int i, int lastIndex) {
        // 查看是否存在孩子节点
        while (2 * i + 1 <= lastIndex) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int large;
            // 找到 当前节点 和 左右节点的最大值
            if (left <= lastIndex && nums[left] > nums[i]) {
                large = left;
            } else {
                large = i;
            }
            // 这儿和刚刚的 large比
            if (right <= lastIndex && nums[right] > nums[large]) {
                large = right;
            }
            if (i != large) {
                swap(nums, i, large);
                // 如果最大值是孩子节点，那么交换，并且需要继续遍历交换后的(large)的孩子节点们，可能会发生变化
                i = large;
            } else {
                // 当前位置就是最大值 那么不用循环了
                break;
            }
        }
    }


    int[] tmp;
    // 归并排序
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= right) {
            tmp[cnt++] = nums[j++];
        }
        // 对应nums的数组位置  将tmp中的值放回   tmp每次都是从0开始缓存，获得本次的长度 right - left + 1
        for (int k = 0; k < right - left + 1; k++) {
            nums[k + left] = tmp[k];
        }
    }
}
