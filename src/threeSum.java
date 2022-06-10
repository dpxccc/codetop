import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author diaopx
 * @date 2022/3/28 11:07
 * <p>
 * 15.三数之和
 */
public class threeSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.print("输入多少个数：");
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            threeSum t = new threeSum();
            System.out.println(t.threeSum(nums));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int n1 = nums[i];
            if (n1 > 0) {
                // 第一个数已经大于0   说明不存在使得等于0的三个数
                return res;
            }
            // 跳过相同的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = n1 + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(n1, nums[left], nums[right]));
                    left++;
                    right--;
                    // 跳过相同数
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum > 0) {
                    // 说明这次的总和较大，需要将right左移
                    right--;
                    // 数相同时
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    // sum较小，left右移
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
