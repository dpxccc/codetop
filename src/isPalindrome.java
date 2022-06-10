/**
 * @author diaopx
 * @date 2022/4/20 14:53
 * <p>
 * 234.回文链表
 */
public class isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将后半段的链表翻转
        ListNode node = reverse(slow.next);
        // 断链
        slow.next = null;
        // 后半段链表长度 <= 前半段。相差不超过1
        while (node != null) {
            if (head.val != node.val) {
                return false;
            }
            node = node.next;
            head = head.next;
        }
        return true;
    }


    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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
