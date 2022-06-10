/**
 * @author diaopx
 * @date 2022/3/30 15:34
 * <p>
 * 142.环形链表II
 */
public class detectCycle {

    /*public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 找到环
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将slow重置到head,并和fast同步走       fast是从head.next开始算，所以走的总步数是2 * slow + 1
        slow = head;
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }*/

    /**
     * head到环入口长度为c，slow一共走了 n 步，则fast为 2n 步，fast比slow多走了 k*n 步（即k圈）。
     * 所以 n是环长度的倍数。slow在环内走了n-c步，fast(或者slow）从head开始一步一步走c步，fast在环内相遇位置一步一步走
     * slow 走了c步到环入口，fast在环内走了 c 步，n-c+c = n步，也到环入口     相遇。
     * 可以自己画图理解
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            // 找到环
            if (slow == fast) {
                // slow 放到head，重新和fast一步一步走，  相遇位置就是环入口
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        // fast == null 弹出  则为没有环
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
