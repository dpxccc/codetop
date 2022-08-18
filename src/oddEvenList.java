/**
 * @Author diaopx
 * @Date 2022/8/18 8:52
 *
 * 328.奇偶链表
 **/
public class oddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode head2 = head.next;
        ListNode q = head.next;
        ListNode cur = q.next;
        while (cur != null) {
            p.next = cur;
            p = p.next;
            cur = cur.next;
            q.next = cur;
            q = q.next;
            if (cur != null) {
                cur = cur.next;
            }
        }
        p.next = head2;
        return head;
    }
}
