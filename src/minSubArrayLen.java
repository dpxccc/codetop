import java.util.Arrays;

/**
 * @author diaopx
 * @date 2022/5/22 21:33
 * <p>
 * 209.长度最小的子数组
 */
public class minSubArrayLen {

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int minLen = n + 1;
        int left = 0, right = 0;
        int count = 0;
        while (right < n) {
            count += nums[right];
            while (left <= right && count >= target) {
                // 找到 >= target 的最短长度
                minLen = Math.min(minLen, right - left + 1);
                count -= nums[left];
                left++;
            }
            right++;
        }
        // 如果还是n+1 是不存在的，说明不存在 大于等于target的子数组
        return minLen == n + 1 ? 0 : minLen;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < n + 1; i++) {
            // 找左边界  目标值为 target + sum[i]
            int bound = binary(sum, i - 1, target + sum[i - 1]);
            if (bound == -1) {
                break;
            }
            ans = Math.min(ans, bound - i);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int binary(int[] sum, int i, int target) {
        int left = i, right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return sum[left] >= target ? left : -1;
    }
}
