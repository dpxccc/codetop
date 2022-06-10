/**
 * @author diaopx
 * @date 2022/4/19 18:36
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


    // 回溯
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return dfs(0, targetSum, root);
    }

    private boolean dfs(int sum, int targetSum, TreeNode root) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return targetSum == sum;
        }
        boolean isLeft = false;
        if (root.left != null) {
            isLeft = dfs(sum, targetSum, root.left);
        }
        boolean isRight = false;
        // 只要左子树满足条件了就不需要继续递归右子树了  剪枝
        if (!isLeft && root.right != null) {
            isRight = dfs(sum, targetSum, root.right);
        }
        return isLeft || isRight;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
