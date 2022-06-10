import java.util.LinkedList;

/**
 * @author diaopx
 * @date 2022/4/16 17:25
 * <p>
 * 143.重排链表
 */
public class reorderList {

    /**
     * （1）找到中点分割链表 （2）翻转链表   （3）插入链表
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow.next 是后半段链表的头结点  翻转后半链表
        ListNode node = reverse(slow.next);
        // 断开前半段链表
        slow.next = null;
        // 合并两个链表
        merge(head, node);
    }

    // 翻转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 合并链表
    public void merge(ListNode head1, ListNode head2) {
        while (head2 != null && head1 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head2.next = tmp1;
            head1.next = head2;
            head1 = tmp1;
            head2 = tmp2;
        }
    }

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
}
