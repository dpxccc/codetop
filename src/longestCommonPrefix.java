/**
 * @author diaopx
 * @date 2022/4/20 10:40
 * <p>
 * 14.最长公共前缀
 */
public class longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        // 对于第一个单词的字符  能不能满足条件
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                // 后续的str中和第一个是否相同   或者  单词长度不够
                if (strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 1) {
                    return "";
                }
                // 如果s不是该str的前缀，则缩短到是他的前缀
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
