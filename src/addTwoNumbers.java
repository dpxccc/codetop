/**
 * @author diaopx
 * @date 2022/4/19 10:42
 * <p>
 * 2.两数之和
 */
public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = null;
        // 进位
        int carry = 0;
        while (head1 != null && head2 != null) {
            carry += head1.val + head2.val;
            head1.val = carry % 10;
            // 缓存 head1的下一个节点
            ListNode tmp = head1.next;
            // 将head1 插入pre后面
            head1.next = pre.next;
            pre.next = head1;
            head1 = tmp;
            head2 = head2.next;
            // pre 一直指向尾结点
            pre = pre.next;
            // 获取进位  如果超过10 则会进位 1
            carry /= 10;
        }
        // 处理剩余节点
        while (head1 != null && carry == 1) {
            carry += head1.val;
            ListNode tmp = head1.next;
            // 修改有进位的节点的值  然后加入pre 后面，并且pre一直指向尾指针
            head1.val = carry % 10;
            head1.next = pre.next;
            pre.next = head1;
            pre = pre.next;
            head1 = tmp;
            carry /= 10;
        }
        while (head2 != null && carry == 1) {
            carry += head2.val;
            ListNode tmp = head2.next;
            // 修改有进位的节点的值  然后加入pre 后面，并且pre一直指向尾指针
            head2.val = carry % 10;
            head2.next = pre.next;
            pre.next = head2;
            pre = pre.next;
            head2 = tmp;
            carry /= 10;
        }
        if (head1 != null) {
            pre.next = head1;
        }
        if (head2 != null) {
            pre.next = head2;
        }
        // 如果还有进位  说明位数+1
        if (carry > 0) {
            ListNode node = new ListNode(1);
            node.next = pre.next;
            pre.next = node;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        // 尾指针
        ListNode tail = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            // 超过长度了 则默认为0
            int num1 = head1 == null ? 0 : head1.val;
            int num2 = head2 == null ? 0 : head2.val;
            carry += num1 + num2;
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry /= 10;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(1);
        }
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
