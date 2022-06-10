import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/14 10:42
 * <p>
 * <p>
 * 94.中序遍历
 */
public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
//        stack.push(node);
//        node = node.left;
        // 节点为空时 则弹栈，然后判断右节点
        while (!stack.isEmpty() || node != null) {
            // 不为空则压入栈，并找左节点
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                // 弹栈，并加入ans，然后判断弹栈tmp的右节点
                TreeNode tmp = stack.pop();
                ans.add(tmp.val);
                node = tmp.right;
            }
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
