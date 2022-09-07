import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/9/7 16:56
 * <p>
 * 99.恢复二叉树
 **/
public class recoverTree {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                // 找到逆序对， 第一次保存pre和node，防止就是只有这两个属于逆序对，第二次保存node
                if (pre != null && node.val < pre.val) {
                    if (firstNode == null) {
                        firstNode = pre;
                        secondNode = node;
                    } else {
                        secondNode = node;
                    }
                }
                pre = node;
                root = node.right;
            }
        }
        swap(firstNode, secondNode);
    }

    private void swap(TreeNode firstNode, TreeNode secondNode) {
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
}
