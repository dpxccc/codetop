import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/10/18 15:08
 *
 * 902.最大为N的数字组合
 **/
public class atMostNGivenDigitSet {

    int[] nums;
    char[] s;
    int[] dp;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        nums = new int[digits.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        dp = new int[m];
        Arrays.fill(dp, -1);
        return dfs(0, true, false);
    }

    // 返回第i位 能够达到的所有方案数
    public int dfs(int i, boolean isLimit, boolean hasNum) {
        if (i == s.length) return hasNum ? 1 : 0;
        if (!isLimit && hasNum && dp[i] != -1) return dp[i];
        int res = 0;
        // 前面不取值时  构建位数较小的情况
        if (!hasNum) res = dfs(i + 1, false, false);
        // 能取的上界
        int up = isLimit? s[i] - '0' : 9;
        // 从nums中取值
        for (int num : nums) {
            if (num > up) break;
            res += dfs(i + 1, isLimit && num == up, true);
        }
        if (!isLimit && hasNum) dp[i] = res;
        return res;
    }
}
