import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/9/19 12:09
 * <p>
 * 1023.驼峰式匹配
 **/
public class camelMatch {


    public static void main(String[] args) {
        camelMatch c = new camelMatch();
        System.out.println(c.camelMatch(new String[]{"ForceFeedBack"}, "FB"));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(check(query, pattern));
        }
        return ans;
    }

    public boolean check(String query, String pattern) {
        int m = query.length(), n = pattern.length();
        if (m < n) return false;
        int i = 0, j = 0;
        while (i < m) {
            char ch1 = query.charAt(i);
            if ((j == n || ch1 != pattern.charAt(j)) && ch1 >= 'A' && ch1 <= 'Z') return false;
            if (j < n && ch1 == pattern.charAt(j)) j++;
            // 当前j==n了或者ch1和pattern不相等   并且ch1是大写字母与
//            else if (ch1 <= 'Z' && ch1 >= 'A') return false;
            i++;

        }
        return j == n;
    }
}
