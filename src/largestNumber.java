import java.util.Arrays;

/**
 * @author diaopx
 * @date 2022/5/8 16:19
 * <p>
 * 179.最大数
 */
public class largestNumber {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            // 从大到小
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }
        // 特判全部是0
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
