import java.util.Arrays;

/**
 * @author diaopx
 * @date 2022/4/16 16:00
 * <p>
 * 300.最长递增子序列
 */
public class lengthOfLIS {

    public static void main(String[] args) {
        lengthOfLIS l = new lengthOfLIS();
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] path = new int[n];
        // 初试状态最长长度都是1
        Arrays.fill(dp, 1);
        // 每个点的来源都是自身
        Arrays.fill(path, -1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 记录路径
                    if (dp[i] < dp[j] + 1) {
                        path[i] = j;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (ans == dp[i]) {
                end = i;
            }
        }
        while (end >= 0) {
            System.out.println(nums[end]);
            end = path[end];
        }
        return ans;
    }

/*     public int lengthOfLIS(int[] nums) {
         //tails表示长度为i(取0-n-1)的递增子序列的末尾元素的最小值
          //保存能组成 i 长度的最后面的最小元素
         int[] tails = new int[nums.length];
         int res = 0;
         for(int num : nums) {
             int i = 0, j = res;      // j是res，会指向最后一个数的后一位，如果j最终没有过改变，说明所有的数都小于num
             *//**二分查找tails数组，如果都比num小，那么num可以加在tails中，如果其中某个数>=num了，那么就需要更新
              * tails数组中的那个值，比如 1，4，6，遇到num=5，那么更新为1，4，5
              * 要是1，4，6遇到的是2，此时res表示最大长度不变，tail数组更新为1，2，6，此时虽然该序列已经不是子序列
              * 但是可以发现是不影响res即lis的，只有在tails中所有数都小于num才会更新res
              * 当tails[m] < num时，i=m+1，否则j=m。至于为什么能二分官方或者k神已经证明了
              *//*
             while(i < j) {
                 int m = (i + j) / 2;
                 if(tails[m] < num) i = m + 1;
                 else j = m; //此处找到的j或者i是tails中元素等于num的左侧边界,左边的都要小于num，所以更新tails[j] = num
             }
             tails[j] = num;
             if(res == j) res++; //res==j表示tails[m] < num始终成立，那么num可以接在之后变成更长的子序列，res++
         }
         return res;
     }*/
}
