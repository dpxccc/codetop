import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/5/10 15:58
 *
 * 145.二叉树的后序遍历
 */
public class postorderTraversal {

    public static void main(String[] args) {
        postorderTraversal p = new postorderTraversal();
        System.out.println(1);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tmp = new TreeNode();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.peek();
                // 判断中间节点node时有可能从 node 的右子树回来，这时需要判断是否刚刚弹出了node.right
                if (node.right != null && tmp != node.right) {
                    root = node.right;
                } else {
                    ans.add(node.val);
                    // 缓存一下刚刚弹出的节点
                    tmp = node;
                    stack.pop();
                    root = null;
                }
            }
        }
        return ans;
    }
}
