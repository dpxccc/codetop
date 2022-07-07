/**
 * @Author diaopx
 * @Date 2022/7/6 19:22
 * <p>
 * 剑指offerII 45 二叉树最底层最左边的值
 **/
public class findBottomLeftValue {

    int max = 0;
    TreeNode ans = null;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans.val;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > max) {
            max = depth;
            ans = node;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
