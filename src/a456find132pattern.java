import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

/**
 * @Author diaopx
 * @Date 2022/12/15 9:43
 *
 * 456.132模式
 **/
public class a456find132pattern {

    /**
     * 从后往前遍历，定义132序列为  ijk，维护一个单调递减的序列，当一个大数进入单调栈，k更新为弹出的最大值（其实k最后弹出的就是最大的，有单调性）
     * 如果遍历到i位置  nums[i] < nums[k]了   因为k是在弹出时更新的，所以栈中一定有一个比他大的数，所以满足了132格式
     */
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 记录后面的最大值
        int k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = stack.pop();
                // k具有单调性，因为是单调减的序列，越往下弹就越大
//                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
