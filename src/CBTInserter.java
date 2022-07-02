import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author diaopx
 * @Date 2022/7/1 23:31
 * <p>
 * 剑指offerII 43.往完全二叉树添加节点
 **/
public class CBTInserter {

    TreeNode root = new TreeNode();
    Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue.offer(root);
        // 队列中只保存 左右孩子不全的节点
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        // 如果头结点没有左孩子 则直接加入
        if (parent.left == null) {
            // 这儿不需要把左孩子加入，在左右孩子都存在，父节点出队时 才把左右孩子入队，这儿先入队，后面会在else时重复入队
            parent.left = new TreeNode(v);
        } else {
            // 有左孩子了，则加入的节点是右孩子，需要把parent出队
            parent.right = new TreeNode(v);
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
