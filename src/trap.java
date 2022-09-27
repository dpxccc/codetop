import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/9/27 10:34
 *
 * 42.接雨水
 **/
public class trap {

    // 对双指针的理解：

    // left从左向右遍历，right从右向左遍历；

    // 则对left来说，leftMax一定准确，rightMax不一定准确，因为区间（left, right）的值还没有遍历，但是left的rightMax一定 >= right的rightMax，
    // 所以只要leftMax < rightMax时，我们不关系left的rightMax是多少了，因为它肯定比leftMax大，我们可以直接计算出left的存水量leftMax - nums[left];

    // 对right来说，rightMax一定准确，leftMax不一定准确，因为区间（left, right）的值还没有遍历，但是right的leftMax一定 >= left的leftMax，
    // 所以只要leftMax >= rightMax时，我们不关系right的leftMax是多少了，因为它肯定比rightMax大，我们可以直接计算出right的存水量rightMax - nums[right];

    // 双指针
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0, left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            // 哪边的max小，则优先填充 那一边
            if (leftMax < rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }

   /* // 动态规划
    public int trap(int[] height) {
        int n = height.length;
        // 包含自己在内的 左边的最大值  右边最大值
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        // 判断每一列能够填充的数量
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            // 只有中间小，两边大才满足
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }*/

    /*public int trap(int[] height) {
        // 单调栈 记录大值的索引
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // 依次判断每个弹栈的位置能够放的数量
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 当前弹栈就是最矮的位置
                int low = stack.pop();
                // 因为没有左边界的话，无法盛放水
                if (stack.isEmpty()) break;
                // 左边界
                int left = stack.peek();
                int width = i - left - 1;
                int hi = Math.min(height[left], height[i]);
                ans += (hi - height[low]) * width;
            }
            stack.push(i);
        }
        return ans;
    }*/
}
