import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/9/25 19:30
 * <p>
 * 863
 **/
public class distanceK {

    Map<Integer, TreeNode> parent = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        getParent(null, root);
        dfs(target, target, 0);
        return ans;
    }

    public void getParent(TreeNode pre, TreeNode cur) {
        if (cur == null) return;
        parent.put(cur.val, pre);
        getParent(cur, cur.left);
        getParent(cur, cur.right);
    }

    public void dfs(TreeNode node, TreeNode from, int len) {
        if (node == null) return;
        if (len == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != null && node.left != from) {
            dfs(node.left, node, len + 1);
        }
        if (node.right != null && node.right != from) {
            dfs(node.right, node, len + 1);
        }
        if (parent.get(node.val) != null && parent.get(node.val) != from) {
            dfs(parent.get(node.val), node, len + 1);
        }
    }
}
