import java.util.HashMap;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/9/22 16:37
 * <p>
 * 567
 **/
public class checkInclusion {


    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            need[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < n) {
            window[s2.charAt(right++) - 'a']++;
            if (right - left == s1.length()) {
                if (isEqual(need, window)) {
                    return true;
                }
                window[s2.charAt(left++) - 'a']--;
            }
        }
        return false;
    }

    public boolean isEqual(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}
