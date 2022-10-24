import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/10/24 15:50
 * <p>
 * 51.N皇后
 **/
public class solveNQueens {

    List<List<String>> ans = new ArrayList<>();
    int[] visited;
    int n;

    public List<List<String>> solveNQueens(int n) {
        // 记录每一行存放的 列位置
        visited = new int[n];
        this.n = n;
        Arrays.fill(visited, -1);
        dfs(new ArrayList<>(), 0, new StringBuilder());
        return ans;
    }

    public void dfs(List<String> list, int row, StringBuilder sb) {
        if (row == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(row, i)) {
                sb.append("Q");
                // 记录当前行 填写的位置
                visited[row] = i;
                for (int j = 0; j < n - i - 1; j++) {
                    sb.append(".");
                }
                // 将sb加入当前list
                list.add(sb.toString());
                dfs(list, row + 1, new StringBuilder());
                // 回溯
                list.remove(list.size() - 1);
                sb.setLength(i);
                // 把当前位置替换为 .
                sb.append(".");
                visited[row] = -1;
            } else {
                sb.append(".");
            }
        }
    }

    /**
     * i行 j列的位置是否满足要求
     */
    public boolean check(int i, int j) {
        for (int k = 0; k < i; k++) {
            // 列号相同 || 行差 == 列差
            if (visited[k] == j || Math.abs(i - k) == Math.abs(visited[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
