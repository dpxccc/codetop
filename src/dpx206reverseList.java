/**
 * @author diaopx
 * @date 2022/3/24 16:52
 */
public class dpx206reverseList {

    class ListNode {
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

    // 迭代法
    /*public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode q = head;
        ListNode p = head.next;
        q.next = null;
        while(p != null){
            ListNode tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        return q;
    }*/

    // 递归法
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
        return reverse(pre, cur);
    }
}
