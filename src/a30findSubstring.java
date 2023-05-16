import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author diaopx
 * @Date 2022/11/16 10:40
 *
 * 30.串联所有单词的子串
 **/
public class a30findSubstring {

    public static void main(String[] args) {
		String a = "dev";
        a30findSubstring a = new a30findSubstring();
        System.out.println(a.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int m = words.length, n = words[0].length();
        int len = s.length();
        // 遍历起始位置就好
        for (int i = 0; i < n; i++) {
            // 起始位置不能从该位置开始划分
            if (i + m * n > len) break;
            Map<String, Integer> map = new HashMap<>();
            // 初始化 words中的单词频次
            for (int j = 0; j < m; j++) {
                map.put(words[j], map.getOrDefault(words[j], 0) + 1);
            }
            // 初始化 s i开始到i + m + n 拆分出的单词频次
            for (int j = i; j < i + m * n; j += n) {
                String w = s.substring(j, j + n);
                map.put(w, map.getOrDefault(w, 0) - 1);
                if (map.get(w) == 0) map.remove(w);
            }
            if (map.isEmpty()) ans.add(i);
            // 往后移动窗口，left 是一个窗口的开始位置,right是下一个单词的开始位置  移动的顺序就是前面删除一个word，后面加上一个word
            int left = i, right = i + m * n;
            while (right + n <= len) {
                String w = s.substring(left, left + n);
                // 删除前面的
                map.put(w, map.getOrDefault(w, 0) + 1);
                if (map.get(w) == 0) map.remove(w);
                // 获取后面的
                w = s.substring(right, right + n);
                map.put(w, map.getOrDefault(w, 0) - 1);
                if (map.get(w) == 0) map.remove(w);
                right += n;
                left += n;
                if (map.isEmpty()) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }

}
