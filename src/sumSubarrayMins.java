import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author diaopx
 * @Date 2022/10/28 10:14
 *
 * 907.子数组的最小值之和
 **/
public class sumSubarrayMins {

    /**
     以当前元素为最右且最小的元素的子序列个数x，以当前元素为最左且最小的元素的子序列个数y
     最终 以当前元素为最小的元素能够组成的总序列个数是 x * y（注意不要重复） 规定当前元素在左边序列
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)(1e9 + 7);
        // 找到小于当前元素 的左边位置  和  小于当前元素的右边位置
        int[] left = new int[n];
        int[] right = new int[n];
        // 存下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 找到前面 第一个小于arr[i]的位置
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 防止重复计算，这儿找右边 小于等于 arr[i]的位置
            // 例如 1 2 3 1 5 1   对中间的1，左边的全部包含了，右边到3,1（不能取）  因为最右边的1,会包含1 3 1
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // 将当前位置放在左边的位置上，左边长度 * 右边长度就是能够构成的总个数
            ans += (arr[i] * 1L * (i - left[i]) * (right[i] - i)) % mod;
            ans %= mod;
        }
        return (int)ans;
    }
}
