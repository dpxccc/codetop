/**
 * @author diaopx
 * @date 2022/4/17 10:25
 * <p>
 * 19.删除链表的倒数第N个节点
 */
public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 双指针  相差 n 步
        ListNode p = head;
        while (n != 0 && p != null) {
            p = p.next;
            n--;
        }
        // 如果是p == null 跳出了 ，而n != 0 说明长度不够
        // 不用写。题目已经规定好了条件
        if (n != 0) {
            return null;
        }
        ListNode q = head;
        ListNode pre = dummy;
        while (p != null) {
            p = p.next;
            q = q.next;
            pre = pre.next;
        }
        // 删除节点
        pre.next = q.next;
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
