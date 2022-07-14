/**
 * @Author diaopx
 * @Date 2022/7/14 19:26
 * <p>
 * 75.颜色分类
 **/
public class sortColors {

    public void sortColors(int[] nums) {
        // p指向0的后面一位，q指向1的后面一位，当碰到0的时候p和q都需要后移
        int p = 0, q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p);
                // 把0交换到前面的时候，可能把1 放到了最后，需要判断是否再交换一次
                if (p < q) swap(nums, i, q);
                p++;
                q++;
            } else if (nums[i] == 1) {
                swap(nums, i, q);
                q++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
