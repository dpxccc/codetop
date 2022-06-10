/**
 * @author diaopx
 * @date 2022/4/1 9:59
 * <p>
 * 33.搜索旋转排序数组
 */
public class search {

    public static void main(String[] args) {
        search search = new search();
        int[] nums = {1,3};
        System.out.println(search.search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 可能存在只能两个的情况，4,5,6,7,8,9,10,0,1,2,3这种情况下寻找0，
            // 会遍历到剩下10,0，的情况，nums[mid]=10，右边最小值不是mid的地方，应该归类到左边
            if (nums[left] <= nums[mid]) {
                // 左边半边有序
                if (nums[left] <= target && target < nums[mid]) {
                    // target在左边有序数组中
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边半边有序
                if (nums[mid] < target && target <= nums[right]) {
                    // target在右边有序数组中
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
