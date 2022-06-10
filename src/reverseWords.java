/**
 * @author diaopx
 * @date 2022/4/16 10:35
 * <p>
 * 151.颠倒字符串中的单词
 */
public class reverseWords {

    public static void main(String[] args) {
        reverseWords r = new reverseWords();
        System.out.println(r.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(cleanSpace(s));
        sb = reverseSingleWord(sb);
//        System.out.println(sb.toString());
        sb = reverseString(sb);
        return sb.toString();
    }

    public StringBuilder cleanSpace(String s) {
        int left = 0, right = s.length() - 1;
        // 左右两边 找到第一个非空格字符
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        // 删除中间多余的空格
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                sb.append(ch);
            } else if (s.charAt(left - 1) != ' ') {
                // 此时ch == ' '; 如果前一个不是空格则添加
                sb.append(ch);
            }
            left++;
        }

        return sb;
    }


    public StringBuilder reverseSingleWord(StringBuilder sb) {
        int left = 0, right = 0;
        while (right < sb.length()) {
            char ch = sb.charAt(right);
            if (ch != ' ') {
                // 往最左边插入，然后删除右边的ch
                sb.insert(left, ch);
                sb.deleteCharAt(right + 1);
            } else {
                // 碰到空格则跳转到下一个单词头部
                left = right + 1;
            }
            right++;
        }
        return sb;
    }

    // 左右两边交换字符
    public StringBuilder reverseString(StringBuilder sb) {
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            left++;
            right--;
        }
        return sb;
    }


}
