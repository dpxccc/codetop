import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/5/2 15:26
 * <p>
 * 337.打家劫舍III
 */
public class robIII {

    // 方法一，记忆化递归
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        // 选择当前节点
        int val1 = root.val;
        // 跳过下一层
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 不选该节点
        int val2 = 0;
        val2 += rob(root.left) + rob(root.right);
        // 记录当前节点
        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }


    // 树形dp
    public int rob2(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    public int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        // 后序遍历 左右子树的结果
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 0: 不选当前节点，则选择左右孩子各自的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
