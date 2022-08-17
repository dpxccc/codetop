import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/8/16 15:37
 * <p>
 * 剑指offerII 80 含有k个元素的组合
 **/
public class combine {

    List<List<Integer>> ans = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(new ArrayList<>(), 1);
        return ans;
    }

    public void dfs(List<Integer> list, int start) {
        if (n - start + 1 < k - list.size()) return;
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
