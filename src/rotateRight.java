import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/6/18 15:18
 *
 * 61.旋转链表
 **/
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int cnt = 1;
        while (tail.next != null) {
            cnt++;
            tail = tail.next;
        }
        // 找到应该返回的点的序号
        k %= cnt;
        // 如果不需要旋转  则直接返回
        if (k == 0) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        int tmp = cnt - k;
        while (tmp != 0) {
            pre = cur;
            cur = cur.next;
            tmp--;
        }
        pre.next = null;
        tail.next = head;
        return cur;
    }
}
