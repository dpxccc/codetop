import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/17 10:37
 * <p>
 * 199.二叉树的右视图
 */
public class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        // 根节点开始   深度为0
        dfs(root, 0);
        return ans;
    }

    // 根 - 右 - 左
    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 就添加一次 和 ans大小相同的情况  ans.size 就是下一个要添加的深度的第一个。每个深度只添加一个
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        // 先右后左   右边的会优先找到。
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }


    class TreeNode {
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
