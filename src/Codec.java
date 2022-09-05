import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author diaopx
 * @Date 2022/9/5 14:02
 * <p>
 * 297.二叉树的序列化和反序列化
 **/
public class Codec {

    /*// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if ("".equals(data)) return null;
        String[] arr = data.split(",");
        int idx = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        idx++;
        while (idx < arr.length && !queue.isEmpty()) {
            if (arr[idx] == null || arr[idx].equals("")) {
                idx++;
                continue;
            }
            TreeNode node = queue.poll();
            if (arr[idx].equals("#")) {
                node.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(arr[idx]));
                node.left = left;
                queue.offer(left);
            }
            idx++;
            if (arr[idx].equals("#")) {
                node.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(arr[idx]));
                node.right = right;
                queue.offer(right);
            }
            idx++;
        }
        return root;
    }*/


    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "#,";
        } else {
            sb.append(root.val);
            sb.append(",");
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
        }
        return sb.toString();
    }


    private int temp = 0;
    private String ans[];

    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data.equals("#,")) return null;
        ans = data.split(",");
        return createTree();
    }

    public TreeNode createTree() {
        if ("#".equals(ans[temp])) {
            temp++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ans[temp]));
        temp++;
        root.left = createTree();
        root.right = createTree();
        return root;
    }
}
