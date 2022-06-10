import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/4/25 19:59
 * <p>
 * 105.从前序和中序遍历序列构建二叉树
 */
public class buildTree {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     *
     * @param preorder
     * @param inorder
     * @param preLeft   前序遍历的区间左端点
     * @param preRight  前序遍历的区间右端点
     * @param inLeft    中序遍历的区间左端点
     * @param inRight   中序遍历的区间右端点
     * @return
     */
    public TreeNode build(int[] preorder, int[] inorder,
                          int preLeft, int preRight,
                          int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点是根节点
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        // 找到中序遍历中根节点的位置
        int inorderPivot = indexMap.get(pivot);
        // 该根节点下左子树的树目
        int num = inorderPivot - inLeft;
        // 构建左子树。先序遍历中「从 左边界+1 开始的 num」个元素就对应了中序遍历中「从 左边界 开始到 inorderPivot-1」的元素
        root.left = build(preorder, inorder, preLeft + 1, preLeft + num, inLeft, inorderPivot - 1);
        // 构建右子树。先序遍历中「从 左边界+1+num 开始到 右边界」的元素就对应了中序遍历中「从 inorderPivot+1 到 右边界」的元素
        root.right = build(preorder, inorder, preLeft + num + 1, preRight, inorderPivot + 1, inRight);

        return root;
    }
}
