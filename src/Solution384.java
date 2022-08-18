import java.util.Random;

/**
 * @Author diaopx
 * @Date 2022/8/18 10:29
 * <p>
 * 384.
 **/
public class Solution384 {

    /*
    大致思路： 每次取区间边界的数，让它随机和区间内部任意一个数进行交换 交换过后即被确定 区间缩小
    比如 1,2,3...,10 十个数 如何保证随机打乱？
    我们可以先取最后一位 10 让它和 1-10中任意一个数进行交换
    再取倒数第二位 因为此时最后一位的数字已经在本次乱序数组中被确定 所以让倒数第二位和前9个数中任意一个数字交换

    同理 再取倒数第3位 让它和前8个数中随机一个数字进行交换
    ...
    最后取正数第2位 让它和前2位中随机一个数字交换
    这一套流程下来，整个数组及被打乱, 并且每个数字出现在每个位置上的概率是一致的，每种情况出现概率也一致
*/
    int[] nums;
    int[] ans;

    public Solution384(int[] nums) {
        this.nums = nums;
        this.ans = new int[nums.length];
        System.arraycopy(nums, 0, ans, 0, ans.length);
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        // i 所在的元素和它之前的所有元素包括它自身的随机选一个进行交换
        // 被选的元素就是确定了的
        for (int i = ans.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(ans, i, j);
        }
        return ans;
    }

    public void swap(int[] ans, int i, int j) {
        int tmp = ans[i];
        ans[i] = ans[j];
        ans[j] = tmp;
    }
}
