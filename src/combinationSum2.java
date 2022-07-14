import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/7/14 20:01
 * <p>
 * 40.组合总和II
 **/
public class combinationSum2 {

    public static void main(String[] args) {
        combinationSum2 c = new combinationSum2();
        System.out.println(c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    int[] visited;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        visited = new int[n];
        this.target = target;
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void dfs(int[] candidates, List<Integer> list, int index, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            // 去重，相同且刚刚被排除了
            if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            sum += candidates[i];
            if (sum > target) return;
            visited[i] = 1;
            list.add(candidates[i]);
            dfs(candidates, list, i + 1, sum);
            visited[i] = 0;
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
