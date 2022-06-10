import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author diaopx
 * @date 2022/4/12 23:19
 * <p>
 * 139.单词拆分
 */
public class wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        // 外层背包
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {       // 遍历物品
                // 如果确定dp[j] 是true，且 [j, i - 1] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
                // 所以递推公式是 if([j, i - 1] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
                String word = s.substring(j, i);
                if (set.contains(word) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    int[] memo;
    Set<String> set;

    public boolean wordBreak2(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        set = new HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private boolean dfs(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        // 如果以该起点进行拆分的情况已经判断过   并且是-1表示无法拆分，则返回false
        if (memo[index] == -1) {
            return false;
        }
        for (int i = index; i < s.length(); i++) {
            // 如果截取的字符串不存在set中，说明不能这样拆分，往后移动截取字符串[index - i]
            if (!set.contains(s.substring(index, i + 1))) {
                continue;
            }
            // 继续进行以i+1开始的拆分判断。如果后续以i+1为起点可以截取成功
            if (dfs(s, i + 1)) {
                return true;
            }
        }
        // 遍历完所有无法拆分。记录以index开始的子串是不可以被拆分的
        memo[index] = -1;
        return false;
    }
}
