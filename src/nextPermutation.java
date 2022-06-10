/**
 * @author diaopx
 * @date 2022/4/24 10:56
 * <p>
 * 31.下一个排列
 */
public class nextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n - 2;
        // 从后往前找到第一个上升序列
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int j = n - 1;
            // 找到第一个大数，将一个 尽可能小的「大数」 与前面的「小数」交换
            while (nums[j] < nums[index]) {
                j--;
            }
            swap(nums, index, j);
        }
        // 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列
        reverse(nums, index + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
