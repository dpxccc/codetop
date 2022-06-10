import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/26 16:27
 * <p>
 * 90.子集II
 */
public class subsetsWithDup {

    List<List<Integer>> ans = new ArrayList<>();
    int[] visit;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        visit = new int[n];
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int start, List<Integer> list) {
        if (start > nums.length) {
            return;
        }
        ans.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            // 去重，如果前一个相同的 visit 是0  说明刚刚被remove，现在加入会有重复的
            if (i > 0 && nums[i] == nums[i - 1] && visit[i - 1] == 0) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = 1;
            dfs(nums, i + 1, list);
            visit[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
