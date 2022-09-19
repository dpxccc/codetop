/**
 * @Author diaopx
 * @Date 2022/9/19 9:31
 *
 * 117
 **/
public class connect2 {

    // 先右
    //                  o root
    //                 / \
    //     root.left  o —— o  root.right
    //               /    / \
    //              o —— o   o
    //             /        / \
    //            o        o   o
    public Node connect(Node root) {
        if (root == null) return null;
        // 分别从三个角度判断
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        // 先右后左
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNext(Node node) {
        if (node == null) return null;
        if (node.left != null) return node.left;
        if (node.right != null) return node.right;
        // 这儿就是为啥要先遍历右，因为要先把右节点都连接起来，左节点才可能能找到相应的next
        if (node.next != null) return node.next;
        return null;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
