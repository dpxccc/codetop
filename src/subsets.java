import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/26 15:16
 * <p>
 * 78. 子集
 */
public class subsets {

    public static void main(String[] args) {
        subsets s = new subsets();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return ans;
    }


    public void dfs(int[] nums, List<Integer> list, int start) {
        if (start > nums.length) {
            return;
        }
        ans.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // 解集
        ans.add(new ArrayList<Integer>()); // 首先将空集加入解集中
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size(); // 当前子集数
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(ans.get(j));// 拷贝所有子集
                newList.add(nums[i]); // 向拷贝的子集中加入当前数形成新的子集
                ans.add(newList); // 向lists中加入新子集
            }
        }
        return ans;
    }
}
