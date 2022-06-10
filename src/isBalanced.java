/**
 * @author diaopx
 * @date 2022/4/14 9:11
 * <p>
 * 110.平衡二叉树
 */
public class isBalanced {

    /*boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    public int height(TreeNode node) {
        // 出现过非平衡树时则直接返回，减少递归
        if (node == null || !flag) {
            return 0;
        }
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right);
    }*/

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /***
     * 当node左右子树高度差小于2，返回最大高速。否则返回-1 表示不是平衡树
     * 当存在某个 左右子树的高度为-1时，说明该子树不是平衡树，直接返回-1
     * @param node
     * @return
     */
    public int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        if (left == -1) return -1;
        int right = height(node.right);
        if (right == -1) return -1;
        return (Math.abs(left - right) < 2) ? Math.max(left, right) + 1 : -1;
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
