import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/5/16 16:02
 * <p>
 * 114.二叉树展开为链表
 */
public class flatten {

    // O(1)的空间复杂度
    public void flatten5(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            // 如果其左子节点不为空，则在其左子树中找到最右边的节点
            if (cur.left != null) {
                TreeNode node = cur.left;
                // 找到前驱结点
                while (node.right != null) {
                    node = node.right;
                }
                // 当前节点的右子节点赋给前驱节点的右子节点
                node.right = cur.right;
                // 当前节点的左子节点赋给当前节点的右子节点
                cur.right = cur.left;
                cur.left = null;
            }
            // 继续处理链表中的下一个节点
            cur = cur.right;
        }
    }



    // 右左中
    TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }


    // 中左右
    TreeNode parent = new TreeNode();

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        parent.right = root;
        parent.left = null;
        parent = root;

        flatten(left);
        flatten(right);
    }

    // 后序遍历  左右中
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 防止丢失右节点
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        // 此时的右子树就是刚刚的左子树
        // node在链表中的左节点 应该是原左孩子（现右孩子)的最右下角的节点
        while (root.right != null) {
            root = root.right;
        }
        // 左子树的最下最右的节点，是右子树的父节点.
        root.right = node;
    }


    // 前序遍历的迭代
    public void flatten4(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode pre = new TreeNode();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pre.right = node;
            pre.left = null;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre = node;
        }
    }

}
