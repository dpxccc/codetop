import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/19 14:50
 * <p>
 * 101.对称二叉树
 */
public class isSymmetric {

    /**
     * 法一 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    // 左子树的左孩子 和 右树 右子 &&  左树  右  和   右 左 都要相等
    public boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 判断弹出的两个节点是否满足要求
            if (node1 == null && node2 == null) {
                continue;
            }
            // 两个节点不满足条件的情况
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            // 按一定的顺序添加节点
            // 左 左  和  右  右
            queue.offer(node1.left);
            queue.offer(node2.right);
            // 左 右   和   右  左
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
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
