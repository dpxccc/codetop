/**
 * @author diaopx
 * @date 2022/4/19 19:26
 * <p>
 * 169.多数元素
 */
public class majorityElement {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            // 如果相同 count++
            if (ans == nums[i]) {
                count++;
            } else if (count == 0) {
                // 如果不相同，并且此时的count已经为0，最多的数换了
                ans = nums[i];
                count = 1;
            } else {
                // 不相同  count 不为0
                count--;
            }
        }
        return ans;
    }
}
