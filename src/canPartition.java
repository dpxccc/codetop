import java.util.Scanner;

/**
 * @author diaopx
 * @date 2022/4/6 15:44
 * <p>
 * 416.分割等和子集
 */
public class canPartition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入n:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        canPartition c = new canPartition();
        System.out.println(c.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        // 滚动数组，01背包 外层正序，内层倒序
        int[] dp = new int[target + 1];
        // 初始化  重量为的时候  加值为0
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    /*public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        // 选择数   第二层循环的  重量是nums[i]   加值也是nums[i]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n][target] == target;
    }*/
}
