/**
 * @author diaopx
 * @date 2022/3/27 19:59
 *
 * 55.跳跃游戏
 */
public class canJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        //计算能够抵达的最大长度，最后判断最大长度和n的大小
        int maxLen = nums[0];
        for (int i = 1; i < n; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(maxLen, nums[i] + i);
            }
        }
        return maxLen >= n - 1;
    }
}
