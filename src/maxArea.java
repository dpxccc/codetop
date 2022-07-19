/**
 * @Author diaopx
 * @Date 2022/7/19 11:02
 * <p>
 * 11.盛最多水的容器
 **/
public class maxArea {

    // 双指针。从两边收缩，移动较短的边
    // 因此即使长板往内移动时遇到更长的板，矩形的面积也不会改变；遇到更短的板时，面积会变小。
    // ②因此想要面积变大，只能让短板往内移动(因为移动方向固定了)，当然也有可能让面积变得更小，但只有这样才存在让面积变大的可能性
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
