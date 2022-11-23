import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/11/23 9:58
 *
 * 109.有序链表转化为二叉搜索树
 **/
public class a109sortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head.next, fast = slow.next, pre = head;
        // 找中点
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextHead = slow.next;
        // 断链
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(nextHead);
        return root;
    }

    /*public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<TreeNode> list = new ArrayList<>();
        while (head != null) {
            list.add(new TreeNode(head.val));
            head = head.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    public TreeNode dfs(List<TreeNode> list, int left, int right) {
        if (left > right) return null;
        if (left == right) return list.get(left);
        int mid = left +(right - left) / 2;
        TreeNode root = list.get(mid);
        root.left = dfs(list, left, mid - 1);
        root.right = dfs(list, mid + 1, right);
        return root;
    }*/
}
