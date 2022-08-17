import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/8/17 9:36
 * <p>
 * 131.分割回文串
 **/
public class partition {

    boolean[][] dp;
    List<List<String>> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        // dp[i][j]表示i-j是不是满足回文串
        dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                if (flag && j - i > 1) {
                    // 长度大于2，两边相等时，只需要中间相同就行
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 只有两个元素，相同 不相同 或者 超过两个元素但是首尾不同
                    dp[i][j] = flag;
                }
            }
        }
        dfs(new ArrayList<>(), 0, s);
        return ans;

    }

    public void dfs(List<String> list, int start, String s) {
        if (start == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            // start - i  是不是回文串，是的话，继续向下
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs(list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

}
