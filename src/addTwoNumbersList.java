import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/8/18 9:01
 * <p>
 * 445.两数相加II
 **/
public class addTwoNumbersList {

    // 翻转链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        l1 = reverse(null, l1);
        l2 = reverse(null, l2);
        int carry = 0;
        ListNode ans = null;
        ListNode tmp = null;
        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            if (l1 == null) {
                ListNode node = new ListNode(sum);
                node.next = ans;
                ans = node;
                if (l2 != null)
                    l2 = l2.next;
                continue;
            }
            l1.val = sum;
            // 保存下一节点，然后头插
            tmp = l1.next;
            l1.next = ans;
            ans = l1;
            l1 = tmp;
            if (l2 != null)
                l2 = l2.next;
        }
        return ans;
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return reverse(pre, cur);
    }



    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = ans;
            ans = node;
        }
        return ans;
    }*/
}
