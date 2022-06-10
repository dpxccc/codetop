/**
 * @author diaopx
 * @date 2022/4/16 13:17
 * <p>
 * 92.反转链表II
 */
public class reverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        // 需要旋转 的子链表的头结点
        ListNode node = pre.next;
        // 交换次数 = right - left
        for (int i = left; i < right; i++) {
            // 交换顺序后， node.next就是下一个要交换到前面的节点 1 2 3 4 5 --> 1 3 2 4 5 --> 1 4 3 2 5
            // 获取本次交换的节点
            ListNode cur = node.next;
            // 指向下一个交换的节点
            node.next = cur.next;
            // 将本次的节点cur 插入到pre 和 pre.next之间
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
