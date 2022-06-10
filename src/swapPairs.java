/**
 * @author diaopx
 * @date 2022/5/9 10:01
 * <p>
 * 24.两两交换链表中的节点
 */
public class swapPairs {

    public ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode p = pre.next;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            // 交换p,q
            p.next = q.next;
            pre.next = q;
            q.next = p;
            // 重新赋值p, pre
            pre = p;
            p = p.next;
        }
        return dummy.next;
    }

    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode q = head.next;
        // 前一个节点 指向 q的后续交换过的节点，然后 q 指向head 完成交换
        head.next = swapPairs(q.next);
        q.next = head;
        // return 交换后的头节点
        return q;
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
