/**
 * @author diaopx
 * @date 2022/5/15 10:52
 * <p>
 * 572.另一棵树的子树
 */
public class isSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        // 判断当前树和subRoot是否相同  不同则  左子树或者右子树 是否满足要求
        return  isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.val == node2.val && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
    }
}
