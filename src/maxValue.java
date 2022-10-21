import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/10/21 17:28
 * <p>
 * 1751.最多可以参加的会议数目II
 **/
public class maxValue {

    public static void main(String[] args) {
        maxValue m = new maxValue();
        System.out.println(m.maxValue(new int[][]{{1, 3, 4}, {2, 4, 1}, {1, 1, 4}, {3, 5, 1}, {2, 5, 5}}, 3));
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        // 按结束时间排序
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        // dp[i][j] 代表考虑前 i 个事件，选择的会议数不超过 j 的最大价值
        int[][] dp = new int[n + 1][k + 1];
        // 初始化，一开始选了一个
        for (int i = 1; i < k + 1; i++) {
            dp[0][i] = events[0][2];
        }
        for (int i = 1; i < n; i++) {
            int start = events[i][0], end = events[i][1], val = events[i][2];
            // 二分搜索   当前start >=  前面end的最右边的值 并且不包括当前的start，所以判断条件里要等于start，这样就跳过了前面和start相同的end的值
            int left = 0, right = i - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (events[mid][1] >= start) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            // 找到的点 的结束时间在start值钱
            if (start > events[left][1]) {
                for (int j = 1; j < k + 1; j++) {
                    // 如果要选j个会议的话，那么就是前面选了j-1个
                    dp[i][j] = Math.max(dp[i - 1][j], dp[left][j - 1] + val);
                }
            } else {
                // 没有找到满足条件的点， 只能选当前的一个会议
                for (int j = 1; j < k + 1; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], val);
                }
            }
        }
        return dp[n - 1][k];
    }

}
