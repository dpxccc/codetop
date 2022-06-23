/**
 * @Author diaopx
 * @Date 2022/6/22 17:18
 *
 * 剑指offer 52  两个链表的第一个公共节点
 **/
public class getIntersectionNodejianzhi {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
