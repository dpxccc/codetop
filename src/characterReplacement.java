/**
 * @Author diaopx
 * @Date 2022/9/8 15:46
 *
 * 424.替换后的最长重复字符
 **/
public class characterReplacement {

    // 窗口大小 = 某字符的最大个数maxCnt + 其余字符的个数 （用k把他变成最多的字符）
    // 有个优化，这个maxCnt在left右移时不需要变小，因为最终的长度至少是 d = maxCnt + k
    // 所以后续只需要维持着 d 的窗口大小向后遍历，知道d变大  所以也不需要不停的更新res = Math.max(res, right - left + 1); 最后right - left就是最大的窗口大小
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxCnt = 0;
        int[] map = new int[26];
        int left = 0, right = 0;
        while (right < n) {
            char ch = s.charAt(right);
            map[ch - 'A']++;
            maxCnt = Math.max(maxCnt, map[ch - 'A']);
            if (right - left + 1 > k + maxCnt) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            // res = Math.max(res, right - left + 1);
            right++;
        }
        return right - left;
    }
}
