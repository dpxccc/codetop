import java.util.*;

/**
 * @author diaopx
 * @date 2022/3/29 13:55
 * <p>
 * 103.二叉树的锯齿形层序遍历
 */
public class zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 偶数层则翻转  加入ans        也可以在插入到list时，进行判断，偶数层时将弹出的node一次插入到最前面（LinkedList的offerFirst方法）
            if (step % 2 == 0) {
                Collections.reverse(list);
            }
            step++;
            ans.add(list);
        }
        return ans;
    }


    class TreeNode {
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
