import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/24 19:31
 * <p>
 * 662.二叉树最大宽度
 */
public class widthOfBinaryTree {

    int max = 0;

    public int widthOfBinaryTree2(TreeNode root) {
        // left 存放每一层左节点的下标位置。list大小和depth一样时说明本次节点是本层的最左边节点
        List<Integer> left = new ArrayList<>();
        // 序号从1 开始，高度从0开始
        dfs(root, left, 1, 0);
        return max;
    }

    public void dfs(TreeNode node, List<Integer> left, int index, int depth) {
        if (node == null) {
            return;
        }
        if (depth == left.size()) {
            left.add(index);
        }
        // 计算本次的节点 到左端点的距离  如果刚加入 ，也就是0 + 1。
        max = Math.max(max, index - left.get(depth) + 1);
        dfs(node.left, left, 2 * index, depth + 1);
        dfs(node.right, left, 2 * index + 1, depth + 1);
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        // 下标从1开始
        list.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = list.removeFirst();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(2 * index);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(2 * index + 1);
                }
            }
            // 下一层的最大距离  如果下一层节点数 >= 2 的话
            if (queue.size() >= 2) {
                max = Math.max(max, list.getLast() - list.getFirst() + 1);
            }
        }
        return max;
    }

    public class TreeNode {
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
