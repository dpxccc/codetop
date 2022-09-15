import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/9/15 18:10
 *
 * 76.最小覆盖子串
 **/
public class minWindow {

    public String minWindow(String s, String t) {
        int m  = s.length(), n = t.length();
        if (m < n) return "";
        Map<Character, Integer> seen = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < n; i++) {
            seen.put(t.charAt(i), seen.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 记录t中的不同的字母的数量
        int cnt = seen.size();
        int left = 0, right = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        while (right < m) {
            // 标记该次是否有改变
            boolean flag = false;
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            right++;
            // 判断是不是正好能够 凑够一个字母了
            if (window.get(ch).equals(seen.getOrDefault(ch, 0))) {
                cnt--;
                // 收缩左边界，因为要找最小的长度
                while (left < right && cnt == 0) {
                    char tmp = s.charAt(left);
                    if (window.get(tmp).equals(seen.get(tmp))) {
                        // 因为正好相等的话  移除左边之后tmp这个字符数量不匹配了
                        cnt++;
                    }
                    // 删去左边的字符  计数减一
                    window.put(tmp, window.get(tmp) - 1);
                    left++;
                    flag = true;
                }
            }
            // 此时right已经指向后面一个了，left多移了一个
            if (flag && right - left + 1 < min) {
                min = right - left + 1;
                ans = s.substring(left - 1, right);
            }
        }
        return ans;
    }

}
