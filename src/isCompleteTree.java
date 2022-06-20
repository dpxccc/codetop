import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author diaopx
 * @Date 2022/6/19 10:33
 *
 * 958.二叉树的完全性检验
 **/
public class isCompleteTree {


    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 碰到空节点了，继续遍历后面的
            if (node == null) {
                flag = true;
                continue;
            }
            // 不为空节点时，看看是否已经存在空节点
            if (flag) return false;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }

    public boolean isCompleteTree1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 标记  后面的节点不能有孩子节点
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 左节点不为空，然后判断是否已经不能有孩子节点
            if (node.left != null) {
                if (!flag) {
                    queue.offer(node.left);
                } else {
                    return false;
                }
            } else {
                // 该节点的左孩子为空了，说明该做孩子后面不能有节点
                flag = true;
            }
            if (node.right != null) {
                if (!flag) {
                    queue.offer(node.right);
                } else {
                    return false;
                }
            } else {
                flag = true;
            }
        }
        return true;
    }
}
