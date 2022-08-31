import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/8/31 10:32
 *
 * 611.有效三角形的个数
 **/
public class triangleNumber {

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = n - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            // 固定 一个最大 一个最小
            while (j < k) {
                // 如果前两个数相加 能够大于 最大数，那么 最小到最大之间的所有数  和 k组合都满足，然后把最大数往左移 k--
                if (nums[j] + nums[k] > nums[i]) {
                    ans += k - j;
                    k--;
                } else {
                    // 不满足三角形要求，则把最小数往右移j++
                    j++;
                }
            }
        }
        return ans;
    }
}
