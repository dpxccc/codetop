import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/19 15:32
 * <p>
 * 226.翻转二叉树
 */
public class invertTree {

    // 先序遍历 交换子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 递归交换每个子树的 左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 后序遍历  先从叶子节点开始交换
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先递归左右子树进行子树节点之间的交换
        TreeNode nodeLeft = invertTree2(root.left);
        TreeNode nodeRight = invertTree2(root.right);
        // 最后执行当前根节点下左右子树交换
        root.left = nodeRight;
        root.right = nodeLeft;
        return root;
    }


    // 迭代   层次遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 交换每个节点的左右子树
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // 然后将左右节点加入  虽然左右子树顺序换了，但是要交换的是每个节点的子树
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
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
