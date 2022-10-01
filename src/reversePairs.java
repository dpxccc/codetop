/**
 * @Author diaopx
 * @Date 2022/10/1 15:21
 * <p>
 * 剑指offer51 数组中的逆序对
 **/
public class reversePairs {

    int[] tmp;
    int ans = 0;

    // 利用归并排序解答，在合并的时候，当左边的大于右边，就计算逆序数。
    // 计算公式； mid - left + 1
    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return ans;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // merge操作
        int i = left, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                // **  这个时候 nums[j]和 nums[i]-nums[mid]之间的所有数 构成逆序对 **
                ans += (mid - i + 1);
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= right) {
            tmp[index++] = nums[j++];
        }
        //  将排好序的tmp中的数  重新放到对应区间内的 nums中
        for (int k = 0; k < index; k++) {
            nums[left + k] = tmp[k];
        }
    }

}
