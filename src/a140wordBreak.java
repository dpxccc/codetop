import java.util.*;

/**
 * @Author diaopx
 * @Date 2022/12/10 14:40
 * <p>
 * 140.单词拆分II
 **/
public class a140wordBreak {

    Set<String> set;
    // 记录当前位置为起始位置的 后续有多少个能够组成的string
    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dfs(s, 0);
        return map.get(0);
    }

    public List<String> dfs(String s, int start) {
        if (map.containsKey(start)) return map.get(start);
        List<String> res = new ArrayList<>();
        // 最后一个位置
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            if (set.contains(cur)) {
                StringBuilder sb = new StringBuilder();
                List<String> list = dfs(s, i + 1);
                // 判断的是最后一个位置的时候
                for (String tmp : list) {
                    sb = new StringBuilder(cur);
                    res.add(sb.append(tmp.equals("") ? "" :" ").append(tmp).toString());
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
