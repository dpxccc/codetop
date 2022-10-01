/**
 * @Author diaopx
 * @Date 2022/10/1 10:10
 * <p>
 * 41.缺失的第一个整数
 **/
public class firstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            /*
                它应该呆的位置没有被同伴占有（即存在重复值占有）	nums[nums[i] - 1] != nums[i] 的时候才进行交换
                为什么使用 while ？ 因为交换后，原本 i 位置的 nums[i] 已经交换到了别的地方，
                交换后到这里的新值不一定是适合这个位置的，因此需要重新进行判断交换
                如果使用 if，那么进行一次交换后，i 就会 +1 进入下一个循环，那么交换过来的新值就没有去找到它该有的位置
                 比如 nums = [3, 4, -1, 1] 当 3 进行交换后， nums 变成 [-1，4，3，1]，
                 此时 i == 0，如果使用 if ，那么会进入下一个循环， 这个 -1 就没有进行处理
            */
            // 不能用x代替nums[i]  因为交换后还要用新的nums[i]进行对比
            // 不能只判断当前元素的位置对不对  例如1 1   第二个1的位置不对 会和第一个1交换  造成死循环
            // 需要看的是 需要交换的地方的元素对不对，如果当前位置放置的对，那么要移动过去的地方就是当前位置，所以说要移动到的地方的元素放的对不对其实已经包含了当前位置放置的对不对
            while (nums[i] <= n && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /*public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 只找 最小没出现的正整数，那么1-n都出现过的话，可以把数组填满，ans就是n+1，否则数组填不满
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        // 取abs是因为可能前面已经把后面的置为负数
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            // 没被置为相反数的才需要if
            if (x <= n && nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return n + 1;
    }*/
}
