/**
 * @author diaopx
 * @date 2022/4/5 21:20
 * <p>
 * <p>
 * 96.不同的二叉搜索树
 */
public class numTrees {

    /**
     * dp[i] ： 1到i为节点组成的二叉搜索树的个数为dp[i]。也可以理解是i的不同元素节点组成的二叉搜索树的个数为dp[i]
     *
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 一共i个节点，左边的个数范围是 [0,i-1]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
//                dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
                // 左边j-1个节点就是前面dp[j-1]的组合数，右边亦然
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
