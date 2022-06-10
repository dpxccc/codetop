/**
 * @author diaopx
 * @date 2022/3/31 18:53
 * <p>
 * 160.相交链表
 */
public class getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        // 都走遍m+n，走完自己的  走另一边的
        while(p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p = headA;
        ListNode q = headB;

        while(p != null){
            lenA++;
            p = p.next;
        }
        while(q != null){
            lenB++;
            q = q.next;
        }
        // 将A变成较长的链表
        if(lenA < lenB){
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        int diff = Math.abs(lenA - lenB);
        while(diff != 0){
            headA = headA.next;
            diff--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }*/


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
