import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/9/9 9:36
 *
 * 95.不同的二叉搜索树II
 **/
public class generateTrees {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    /**
     * 构建 start - end之间的所有可能的二叉搜索树  并存入list中返回到上一级
     * @param start 本次构建序列的起点
     * @param end   本次构建序列的终点
     * @return      start - end能够组成的二叉搜索树集合
     */
    public List<TreeNode> build(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        // 以i为根节点构建的二叉搜索树
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            // 将左右子树的所有可能性进行排列组合
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // 构建i的左右子树
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
