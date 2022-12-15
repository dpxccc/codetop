import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/12/15 10:52
 * <p>
 * 1011.在D天内送达包裹的能力
 **/
public class a1011shipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        // 至少保证要最大的一天能够满足   从0开始的话，第三个例子在面对average=2的时候，也能够4天完成，但是weight=3无法满足也算做了一天
        int left = Arrays.stream(weights).max().getAsInt(), right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当所需的天数大于days时说明 需要增加重量
            if (check(weights, mid) > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int check(int[] weight, int average) {
        int res = 1;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            if (sum + weight[i] <= average) {
                sum += weight[i];
            } else {
                sum = weight[i];
                res++;
            }
        }
        return res;
    }
}
