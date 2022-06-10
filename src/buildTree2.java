import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/4/26 10:57
 * <p>
 * 106.从中序与后序遍历序列构造二叉树
 */
public class buildTree2 {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuild(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuild(int[] inorder, int[] postorder,
                            int inLeft, int inRight,
                            int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        // 先找到本次遍历的根节点   后序遍历的最右端节点
        int rootNum = postorder[postRight];
        // 构建根节点
        TreeNode root = new TreeNode(rootNum);
        // 找到根节点在中序遍历中的 索引
        int inorderIndexRoot = indexMap.get(rootNum);
        // 找到该 根节点  的右子树有多少节点
        int sumRight = inRight - inorderIndexRoot;
        // 可以根据sumRight 进行拆分postorder数组，两边分别构建root的左子树和右子树
        // 中序遍历的左右拆分是  inorderIndexRoot 的两端
        // 后序遍历则前半部分是 左子树  后半部分是右子树
        root.left = myBuild(inorder, postorder, inLeft, inorderIndexRoot - 1, postLeft, postRight - sumRight - 1);
        root.right = myBuild(inorder, postorder, inorderIndexRoot + 1, inRight, postRight - sumRight, postRight - 1);
        return root;
    }
}
