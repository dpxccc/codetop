import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/11/23 10:43
 * <p>
 * 173.二叉搜索树迭代器
 **/
public class BSTIterator {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        getNext(root);
    }

    public int next() {
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                getNext(node.right);
            }
            return node.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void getNext(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
