import java.util.PriorityQueue;

/**
 * @author diaopx
 * @date 2022/5/24 15:34
 * <p>
 * 23.合并k个升序链表
 */
public class mergeKLists {


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

    // 方法1  先合并两个  在将结果和接下来的合并
    public ListNode mergeKLists1(ListNode[] lists) {
        int n = lists.length;
        ListNode ans = null;
        for (int i = 0; i < n; i++) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        if (node1 != null) {
            head.next = node1;
        }
        if (node2 != null) {
            head.next = node2;
        }
        return dummyHead.next;
    }

    // 法二 ： 分治
    public ListNode mergeKLists2(ListNode[] lists) {
        return dfs(lists, 0, lists.length - 1);
    }

    public ListNode dfs(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        // 递归合并，dfs左半部分合并，dfs右半部分合并。然后将左右合并
        return merge(dfs(lists, left, mid), dfs(lists, mid + 1, right));
    }


    // 法三 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        // 将每个队列的头结点加入优先队列
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            // 将弹出节点的那个链表的后续节点加入队列
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
