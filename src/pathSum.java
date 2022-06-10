import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/23 14:53
 * <p>
 * 113.路径总和II
 */
public class pathSum {


    List<List<Integer>> ans = new ArrayList<>();
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(TreeNode node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(list));
            }
            //如果这儿return，需要先删除这次加入的节点，不在这儿return，可以继续向下执行，然后会在本次删除本次加入的节点
            // list.remove(list.size() - 1);
            // return;
        }
        dfs(node.left, list, sum);
        dfs(node.right, list, sum);
        list.remove(list.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
