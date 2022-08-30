/**
 * @Author diaopx
 * @Date 2022/8/30 19:52
 *
 * 86.分隔链表
 **/
public class partition86 {

    public ListNode partition(ListNode head, int x) {
        // 构建两个链表
        ListNode dummyP = new ListNode();
        ListNode p = dummyP;
        ListNode dummyQ = new ListNode();
        ListNode q = dummyQ;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = head;
            } else {
                q.next = head;
                q = head;
            }
            head = head.next;
        }
        // 将 大于 x的链表最后断链
        q.next = null;
        p.next = dummyQ.next;
        return dummyP.next;
    }
}
