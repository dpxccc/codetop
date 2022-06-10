import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/15 11:02
 * <p>
 * 47.全排列II
 */
public class permuteUnique {

    int[] visited;
    List<List<Integer>> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        visited = new int[n];
        // 使相同的元素排在一起
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> list) {
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            } else {
                // 如果当前数和前面数相同，并且前面的数没访问，说明是刚刚解除访问，已经添加过相同的了
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                    continue;
                }
                visited[i] = 1;
                list.add(nums[i]);
                dfs(nums, list);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
