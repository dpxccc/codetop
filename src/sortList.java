/**
 * @author diaopx
 * @date 2022/4/20 19:23
 */
public class sortList {

    // 递归   归并排序

    /**
     * 递归的先找到中间节点将链表分为两段，这时就是两个节点比较大小，依次回溯，然后合并成一个链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断链
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归断链
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 合并链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return dummy.next;
    }

    // bottom - top  归并排序的迭代
    // 自底向上归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        // 1. 首先从头向后遍历,统计链表长度
        int length = 0; // 用于统计链表长度
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 2. 初始化 引入dummynode
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
        for (int subLen = 1; subLen < length; subLen <<= 1) { // subLen每次左移一位（即sublen = sublen*2） PS:位运算对CPU来说效率更高
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;     // curr用于记录拆分链表的位置

            while (curr != null) {               // 如果链表没有被拆完
                // 3.1 拆分subLen长度的链表1
                ListNode head_1 = curr;        // 第一个链表的头 即 curr初始的位置
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {     // 拆分出长度为subLen的链表1
                    curr = curr.next;
                }

                // 3.2 拆分subLen长度的链表2
                ListNode head_2 = curr.next;  // 第二个链表的头  即 链表1尾部的下一个位置
                curr.next = null;             // 断开第一个链表和第二个链表的链接
                curr = head_2;                // 第二个链表头 重新赋值给curr
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {      // 再拆分出长度为subLen的链表2
                    curr = curr.next;
                }

                // 3.3 再次断开 第二个链表最后的next的链接
                // 记录下次开始的位置，并且断链
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;   // next用于记录 拆分完两个链表的结束位置
                    curr.next = null;   // 断开连接
                }

                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = merge(head_1, head_2);
                prev.next = merged;        // prev.next 指向排好序链表的头
                // prev每次分割链表长度改变时都会重置到dummy，并且在这儿会移到当前合并后链表的最后，连接下次合并的链表
                while (prev.next != null) {  // while循环 将prev移动到 subLen*2 的位置后去
                    prev = prev.next;
                }
                // 赋值curr为next，开始下次的拆分合并操作
                curr = next;              // next用于记录 拆分完两个链表的结束位置
            }
        }
        // 返回新排好序的链表
        return dummyHead.next;
    }

    // 合并两个有序链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            // 当前指针往后移动
            curr = curr.next;
        }
        curr.next = head1 != null ? head1 : head2;
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
