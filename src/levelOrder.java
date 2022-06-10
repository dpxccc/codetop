import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author diaopx
 * @date 2022/4/1 21:16
 * <p>
 * 102.二叉树的层序遍历
 */
public class levelOrder {

    /*// 递归
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(0, root);
        return ans;
    }

    public void dfs(int step, TreeNode node) {
        if (node == null) {
            return;
        }
        // step 下标从0开始，ans的大小 == step时说明需要创建
        if (step == ans.size()) {
            ans.add(new ArrayList<>());
        }
        // 获取与step对应的list，并将 val放入
        List<Integer> list = ans.get(step);
        list.add(node.val);
        dfs(step + 1, node.left);
        dfs(step + 1, node.right);
    }*/

    // 迭代
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
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
