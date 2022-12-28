/**
 * @Author diaopx
 * @Date 2022/12/28 19:55
 *
 * 53.最大子数组和
 **/
public class a53maxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int preMax = -100001;
        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            ans = Math.max(ans, preMax);
        }
        return ans;
    }
}
