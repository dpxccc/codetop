import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/8/8 12:52
 * <p>
 * 剑指offerII 73 狒狒吃香蕉
 **/
public class minEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            // 计算如果速度是mid的话  需要多少时间
            for (int i = 0; i < n; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }
            // 所需的时间大于h，说明mid较小，左移
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
