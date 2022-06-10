import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/4/26 13:59
 * <p>
 * 98.验证二叉搜索树
 */
public class isValidBST {



    public boolean isValidBST1(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 弹栈时进行判断
                root = stack.pop();
                if (root.val <= pre) {
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }


    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历 左子树
        if (!isValidBST(root.left)) return false;
        // 当前如果 <= 前一个   不满足要求
        if (root.val <= pre) {
            return false;
        }
        // 重新赋值 pre
        pre = root.val;
        return isValidBST(root.right);
    }

    // 中序遍历为升序
    public boolean isValidBST2(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

}
