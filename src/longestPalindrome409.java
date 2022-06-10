import java.util.HashMap;
import java.util.Map;

/**
 * @author diaopx
 * @date 2022/4/18 15:50
 * <p>
 * 409 最长回文串
 */
public class longestPalindrome409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ans += entry.getValue() / 2 * 2;
            if (entry.getValue() % 2 != 0 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
