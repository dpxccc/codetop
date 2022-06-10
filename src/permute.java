import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/15 10:51
 * <p>
 * 49.全排列
 */
public class permute {
    // 标记是否访问过
    int[] visited;
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        this.n = n;
        visited = new int[n];
        dfs(new ArrayList<>(),nums);
        return ans;
    }

    public void dfs(List<Integer> list, int[] nums) {
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 没有访问过
            if(visited[i] != 1){
                // 加入list，并只访问位为1
                list.add(nums[i]);
                visited[i] = 1;
                dfs(list,nums);
                // 回溯，将访问位置为0，并删除最后的数
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
