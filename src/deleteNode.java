/**
 * @author diaopx
 * @date 2022/6/2 10:31
 *
 * 450.删除二叉搜索树中的节点
 */
public class deleteNode {

    public TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        // 没有找到key
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            // 左右子树为空
            cur = null;
        } else if (cur.left == null) {
            cur = cur.right;
        } else if (cur.right == null) {
            cur = cur.left;
        } else {
            // 记录要删除的节点 和 他的父节点
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            // 如果要删除的节点就是 右节点。没有动过
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                // 右子树有左节点
                successorParent.left = successor.right;
            }
            // 把successor替换cur
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        // 如果删除的是根节点
        if (curParent == null) {
            return cur;
        } else {
            // 判断删的是哪一边的节点，key在左边
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                // key在右边
                curParent.right = cur;
            }
            return root;
        }
    }


    // 递归
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // 删除节点的左子树为空
            if (root.left == null) {
                // 返回删除节点的右子树
                return root.right;
            } else if (root.right == null) {
                // 右子树为空，则返回删除节点的左子树
                return root.left;
            } else {
                // 左右子树都存在，则把右子树的最左下节点替代删除节点
                TreeNode successor = minRight(root.right);
                // 先把successor节点删除，并指向返回的右子树。如果先指向left，那么会在deleteMin(root.right)时混乱
                successor.right = deleteMin(root.right);
                // 指向原来的root的左子树，替代root
                successor.left = root.left;
                // 返回以successor为根的子树
                return successor;
            }
        }
    }

    // 找到最左下的节点
    public TreeNode minRight(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //返回删除子树的根
    public TreeNode deleteMin(TreeNode node) {
        // 要删除的节点
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
