import java.util.LinkedList;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/5/2 18:26
 */
public class minDepth {

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return height;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = Math.min(left, minDepth(root.left));
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = Math.min(right, minDepth(root.right));
        }
        return Math.min(left, right) + 1;
    }
}
