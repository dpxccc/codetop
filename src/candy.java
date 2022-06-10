import java.util.Arrays;

/**
 * @author diaopx
 * @date 2022/3/29 10:04
 * <p>
 * 135.分发糖果  困难
 */
public class candy {

    /**
     * 可能会存在 1、3、5、6 这样的   要保证评分更高的糖果更多，1、2、3、4（分配）
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        // 先确定右边评分大于左边的情况（也就是从前向后遍历），右边大的时候  数量需要比前一个多1
        for (int i = 1; i <= n - 1; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        int ans = 0;
        // 确定左边评分比右边大的情况，需要从后往前遍历，因为需要利用该次遍历的上一次的结果，第i个的数量就有两个选择了。
        // 一个是candyVec[i + 1] + 1（从右边这个加1得到的糖果数量），一个是candyVec[i]（之前比较右孩子大于左孩子得到的糖果数量）。
        // 保证第i个小孩的糖果数量即大于左边的也大于右边的。全局最优：相邻的孩子中，评分高的孩子获得更多的糖果。
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
            ans += count[i];
        }
        ans += count[n - 1];
        return ans;
    }
}
