import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/5/16 11:22
 * <p>
 * 138.复制带随机指针的链表
 */
public class copyRandomList {

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            Node clone = new Node(node.val);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while (node != null) {
            // clone 要连接上新的节点  也就是原节点的对应节点
            Node clone = map.get(node);
            clone.next = map.get(node.next);
            clone.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }


    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        // 空间复杂度O(1)，将克隆结点放在原结点后面 1->2->3  ==>  1->1'->2->2'->3->3'
        while (node != null) {
            Node clone = new Node(node.val);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            // 处理random  新的random是原来random的后面一个节点
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 拆分
        node = head;
        Node newHead = head.next;
        // 分离两个两边，依次还原原链表和新链表
        while (node.next != null) {
            // 遍历每个节点，使每个节点都指向相应的节点，并temp保留了下一节点
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return newHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        while (head != null) {
            Node mirror = map.get(head);
            if (head.next != null) {
                map.putIfAbsent(head.next, new Node(head.next.val));
                mirror.next = map.get(head.next);
            }
            if (head.random != null) {
                map.putIfAbsent(head.random, new Node(head.random.val));
                mirror.random = map.get(head.random);
            }
            head = head.next;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
