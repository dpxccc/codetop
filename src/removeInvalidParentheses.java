import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/9/20 15:45
 **/
public class removeInvalidParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        // 需要删除的括号数
        int lRemove = 0, rRemove = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                continue;
            }
            if (ch == '(') {
                lRemove++;
            } else {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        dfs(s, 0, 0, 0, lRemove, rRemove);
        return ans;
    }

    public void dfs(String s, int start, int lCnt, int rCnt, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (check(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 剪枝，跳过相同的字符，刚刚可能已经删除过这个情况了   去重
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                if (s.charAt(i) == '(') {
                    lCnt++;
                } else if (s.charAt(i) == ')') {
                    rCnt++;
                }
                continue;
            }
            // 如果剩下的长度不够 还需要删除的 则跳出
            if (lRemove + rRemove > s.length() - i) {
                return;
            }
            // 删掉左括号
            if (lRemove > 0 && s.charAt(i) == '(') {
                // 删除了左括号  下次还是从i开始  并且lCnt是不变的
                dfs(s.substring(0, i) + s.substring(i + 1), i, lCnt, rCnt, lRemove - 1, rRemove);
            }
            // 删掉右括号
            if (rRemove > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, lCnt, rCnt, lRemove, rRemove - 1);
            }
            if (s.charAt(i) == '(') {
                lCnt++;
            } else if (s.charAt(i) == ')') {
                rCnt++;
            }
            if (lCnt < rCnt) {
                return;
            }
        }
    }

    private boolean check(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                l--;
                if (l < 0) {
                    return false;
                }
            }
        }
        return l == 0;
    }
}
