import java.util.Arrays;

/**
 * @author diaopx
 * @date 2022/3/24 19:47
 */
public class dpx003lengthOfLongestSubstring {


    /**
     * 滑动窗口，右移并且维持窗口内的元素都是一个，出现多个则左指针移动
     *
     * @param s
     * @return
     */
    /*public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            count[ch]++;
            while (left < right && count[ch] > 1) {
                char tmp = s.charAt(left);
                count[tmp]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }*/
    public int lengthOfLongestSubstring(String s) {
        // 记录每一个元素上次出现的下标
        int[] position = new int[128];
        int ans = 0;
        Arrays.fill(position, -1);
        int start = 0;  //窗口开始的位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 需要比较窗口开始位置和 ch上一次存在的位置 ， abba 中第二个a的上次下标是0，而窗口开始位置是2
            // 如果ch在窗口中间存在过，下次窗口的开始位置应该是 position[ch] + 1
            start = Math.max(start, position[ch] +1);
            ans = Math.max(ans, i - start + 1);
            position[ch] = i;   // 更新该字符的下标
        }
        return ans;
    }
}
