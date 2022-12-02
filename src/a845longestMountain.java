/**
 * @Author diaopx
 * @Date 2022/12/2 17:25
 * <p>
 * 845.数组中的最长山脉
 **/
public class a845longestMountain {

    public int longestMountain(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int left = -1;
        boolean isUp = false, isDown = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (isUp && isDown) {
                    ans = Math.max(ans, i - left);
                    left = i - 1;
                    isDown = false;
                }
                isUp = true;
            } else if (arr[i] == arr[i + 1]) {
                // 相同时判断是否需要更新  并在最后重置一下左端点
                if (isUp && isDown) {
                    ans = Math.max(ans, i - left);
                }
                isDown = false;
                isUp = false;
                left = i;
            } else {
                // 没有上升过则直接更新左端点  上升过则继续向后遍历
                if (!isUp) {
                    left = i;
                } else {
                    isDown = true;
                }
            }
        }
        // 到终点了
        if (isUp && isDown) {
            ans = Math.max(ans, n - 1 - left);
        }
        return ans;
    }

}
