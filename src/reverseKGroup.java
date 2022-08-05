/**
 * @Author diaopx
 * @Date 2022/8/5 9:23
 * <p>
 * 25.K个一组反转链表
 **/
public class reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = pre.next;
        // 下一段的头结点不是null
        while (p != null) {
            // 找到此时的头结点，马上就翻转成尾结点了
            ListNode curHead = p;
            int cnt = 1;
            while (cnt < k) {
                p = p.next;
                cnt++;
                if (p == null) {
                    // 此时不够翻转了，则直接连上
                    pre.next = curHead;
                    return dummy.next;
                }
            }
            // 保存好下一段链表的起点
            ListNode tmp = p.next;
            // 断链
            p.next = null;
            // 翻转，并且连上前一段的尾结点
            pre.next = reverse(curHead);
            // 更新
            pre = curHead;
            p = tmp;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode next = node.next;
        node.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = node;
            node = next;
            next = tmp;
        }
        return node;
    }
}
