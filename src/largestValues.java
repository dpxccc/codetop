import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/7/2 15:59
 * <p>
 * 剑指offerII 44 二叉树每层的最大值
 **/
public class largestValues {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (ans.size() == depth) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
