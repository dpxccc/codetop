import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/29 14:41
 * <p>
 * 39.组和总和
 */
public class combinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, 0);
        return ans;
    }

    /**
     * 递归查询所有的结果
     * @param candidates    数组
     * @param list  该次的结果集
     * @param start 下次递归的开始位置，每次从 1 开始遍历会有重复的结果（第一次选择了1，第二次递归选择了5 和  回溯到第一次 选择5，第二次选择了1）重复
     * @param sum
     */
    private void dfs(int[] candidates, List<Integer> list, int start, int sum) {
        if (target == sum) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum -= candidates[i];
            if (sum > target) return;
            list.add(candidates[i]);
            dfs(candidates, list, i, sum);
            // 本次的结果  需要回溯，减去本次添加的值。
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
