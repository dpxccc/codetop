/**
 * @author diaopx
 * @date 2022/5/13 9:44
 *
 * 面试题01.05 一次编辑
 */
public class oneEditAway {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        // 将短的字符串放到前面
        if (len1 > len2) {
            return oneEditAway(second, first);
        }
        int cnt = 0;
        int i = 0, j = 0;
        // 不能越界，如果已经出现cnt > 1的情况则直接跳出
        while (i < len1 && j < len2 && cnt <= 1) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                if (len1 == len2) {
                    i++; j++; cnt++;
                } else {
                    // 这儿是len1 < len2 情况    进行添加操作
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }
}
