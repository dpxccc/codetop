/**
 * @Author diaopx
 * @Date 2022/6/22 17:22
 * <p>
 * 剑指offer53 在排序数组中查找数字
 **/
public class searchjianzhi {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = getLeft(nums, target);
        int right = getRight(nums, target);
        System.out.println(left);
        if (nums[left] != target) {
            return 0;
        }
        System.out.println(right);
        return right - left;
    }

    public int getLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
