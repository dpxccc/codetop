import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/4/21 15:04
 * <p>
 * 剑指offer 54.二叉搜索树的第k大节点
 */
public class kthLargest {

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.left;
            }
        }
        return 0;
    }

    int ans = 0;
    int k = 0;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
