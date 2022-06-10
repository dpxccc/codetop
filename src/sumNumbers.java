import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/26 10:20
 *
 * 129.求根节点到叶节点数字之和
 */
public class sumNumbers {

    /**
     * BFS，队列实现
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue1.offer(root);
        queue2.offer(root.val);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            int num = queue2.poll();
            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }
            if (node.left != null) {
                queue1.offer(node.left);
                queue2.offer(num * 10 + node.left.val);
            }
            if (node.right != null) {
                queue1.offer(node.right);
                queue2.offer(num * 10 + node.right.val);
            }
        }
        return sum;
    }




    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        // 获得到该节点的值  该节点的总值是左右节点值之和
        int sum = num * 10 + node.val;
        // 如果到达叶子结点则 返回总的值
        if (node.left == null && node.right == null) {
            return sum;
        }
        int left = dfs(node.left, sum);
        int right = dfs(node.right, sum);
        return left + right;
    }
}
