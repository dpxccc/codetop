/**
 * @author diaopx
 * @date 2022/3/27 11:18
 * <p>
 * 45.跳跃游戏II
 */
public class jump {

    /**
     * 优化的dp，和贪心一样
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        int cur = 0, next = nums[0];
        for (int i = 0; i < n; i++) {
            // 相同区间内的步数相同，超过上个区间的最远距离了，则步数+1，更新最远距离
            if (i <= cur) {
                dp[i] = count;
            } else {
                dp[i] = ++count;
                cur = next;
            }
            // 这段区间能够到达的最远距离
            next = Math.max(next, i + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 维持每次能够到达的最远距离
     * 这段区间内步数都是ans，并且计算这段区间内的点能够到达的最远距离。
     */
   /*public int jump(int[] nums) {
        int n = nums.length;
        int current = 0;
        int next = nums[0];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 覆盖距离的最大值
            next = Math.max(next, i + nums[i]);
            // 如果覆盖距离超过了n，说明这次跳跃能够抵达终点
            if (next >= n - 1) return ans + 1;
            // 这段区间的步数都是ans，该走下一段区间了，步数+1
            if (i == current) {
                current = next;
                ans++;
            }
        }
        return ans;
    }*/

    /**
     * 最慢
     */
/*    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int tmp = nums[i];
            for (int j = 1; j <= tmp && (i + j) < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }*/

}
