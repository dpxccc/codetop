import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/12/28 20:11
 * <p>
 * 1552.两球之间的磁力
 **/
public class a1552maxDistance {

    // 二分法能够拆分的 值，然后比较 mid 时能够拆分的组数，如果能够拆分的组数>=m 则说明能够拆分
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = (position[n - 1] - position[0]) / (m - 1) + 1;
        while (left < right) {
            // 找能够满足要求的 右边界，  不是找左边界
            int mid = left + (right - left + 1) / 2;
            if (check(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] position, int x, int m) {
        int cnt = 1;
        int last = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - last >= x) {
                last = position[i];
                cnt++;
            }
        }
        return cnt >= m;
    }
}
