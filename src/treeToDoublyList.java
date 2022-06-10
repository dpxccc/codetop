import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author diaopx
 * @date 2022/5/10 10:48
 * <p>
 * 剑指offer 36.二叉搜索树与双向链表
 */
public class treeToDoublyList {
    // 记录前一个节点和头结点
    Node pre, head;

    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        // 遍历的第一个节点，此时pre == null 所以cur 为head
        if (pre == null) {
            head = cur;
        } else {
            // 不是null  则说明前面的右指针 指向cur
            pre.right = cur;
        }
        // 最开始会指向null
        cur.left = pre;
        // 重新赋值 pre 指向 cur
        pre = cur;
        dfs(cur.right);
    }


    // 迭代
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node pre = null, head = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 将左节点全部压入栈中
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null) {
                head = root;
            } else {
                pre.right = root;
            }
            // 即使是head 时  也可以先指向pre(null)
            root.left = pre;
            pre = root;
            // 遍历右节点        不能判断右节点是否存在再去循环，因为root此时已经不是null 了，会死循环
            root = root.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
