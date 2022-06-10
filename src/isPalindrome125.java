/**
 * @author diaopx
 * @date 2022/5/15 10:17
 *
 * 125.验证回文串
 */
public class isPalindrome125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isDigit(s.charAt(left)) && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isDigit(s.charAt(right)) && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // 跳过本次的字符
            left++;
            right--;
        }
        return true;
    }


    class Solution {
        public boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }
}
