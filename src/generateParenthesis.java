import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/25 10:19
 * <p>
 * 22.括号生成
 */
public class generateParenthesis {

    int n;
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(new StringBuilder(),0,0);
        return ans;
    }

    public void dfs(StringBuilder sb, int left, int right) {
        if (left < right || left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            ans.add(new String(sb));
            return;
        }
        sb.append("(");
        dfs(sb, left + 1, right);
        sb.setLength(sb.length() - 1);
        sb.append(")");
        dfs(sb, left, right + 1);
        sb.setLength(sb.length() - 1);
    }
}
