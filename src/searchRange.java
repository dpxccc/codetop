/**
 * @author diaopx
 * @date 2022/4/29 15:33
 * <p>
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * 你天天在卷个什么jb
 * 天天卷nm呢
 */
public class searchRange {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        if (right < left) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};


    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
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

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
