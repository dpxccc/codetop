/**
 * @author diaopx
 * @date 2022/4/6 9:59
 *
 * 283.移动零
 */
public class moveZeroes {

    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    /*public void moveZeroes(int[] nums) {
        int j = 0;
        // 一开始i和j同步移动，j指向第一个0，然后和后面的i交换，j往后移
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                if(j < i){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }*/
}
