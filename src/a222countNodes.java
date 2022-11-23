/**
 * @Author diaopx
 * @Date 2022/11/23 11:15
 *
 * 222.完全二叉树的节点个数
 **/
public class a222countNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // 获取左右子树的高度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            // 左右子树的高度相等  说明左子树是满二叉树，右子树不确定
            // 1(根节点) + (1 << left)-1(左完全左子树节点数) + 右子树节点数量
            return countNodes(root.right) + (1 << left);
        } else {
            // 左右子树高度不想等  说明右子树最底层没有  但是倒数第二层一定是满二叉树
            // 1(根节点) + (1 << right)-1(右完全右子树节点数) + 左子树节点数量
            return countNodes(root.left) + (1 << right);
        }
    }

    // 利用完全二叉树的特性通过 left 计算高度
    public int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}
