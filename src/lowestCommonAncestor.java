import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author diaopx
 * @date 2022/4/1 12:31
 * <p>
 * 236.二叉树的最近公共祖先
 */
public class lowestCommonAncestor {

    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
        if (root == null || root == p || root == q) return root;
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 以下包含了left==null && right==null的情况
        // 左子树不包含p或者q，返回右子树
        if (left == null) {
            return right;
        }
        // 右子树不包含p或者q，返回左子树
        if (right == null) {
            return left;
        }
        // 该根节点下的左右子树分别找到了p和q，此时的最近公共祖先就是root
        return root;
    }*/


    /**
     * 法二
     */
    // 记录每个节点的父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            set.add(p);
            // 递归p的父节点,到root根节点了，则为null
            p = parent.getOrDefault(p.val, null);
        }
        while (q != null) {
            // 如果p的父节点中包含了q的某一个父节点，则是最近的
            if (set.contains(q)) {
                return q;
            }
            q = parent.getOrDefault(q.val, null);
        }
        return null;
    }

    public void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
