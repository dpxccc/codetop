import java.util.*;

/**
 * @Author diaopx
 * @Date 2022/9/25 18:56
 **/
public class topKFrequent692 {

    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(pq.poll().getKey());
            k--;
        }
        return ans;
    }
}
