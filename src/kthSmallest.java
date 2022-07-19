import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/7/19 9:58
 * <p>
 * 230.二叉搜索树中第k小的元素
 **/
public class kthSmallest {

    // 中序遍历
    public int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            root = node.right;
        }
        return root.val;
    }

    // 递归子树的个数
    public int kthSmallest(TreeNode root, int k) {
        // 先看看左子树的个数  这些都是小于 root
        int cnt = sum(root.left);
        if (cnt + 1 == k) {
            return root.val;
        } else if (cnt + 1 > k) {
            // 在左子树上
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - cnt - 1);
        }
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + sum(node.right) + 1;
    }
}
