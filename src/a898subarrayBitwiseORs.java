import java.util.HashSet;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/12/1 10:31
 *
 * 898.子数组按位或操作
 **/
public class a898subarrayBitwiseORs {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x : arr) {
            // 保存以当前数结尾的set
            Set<Integer> cur2 = new HashSet<>();
            // 当前数和前面的set集合内的或结果
            for (int y : cur) {
                cur2.add(y | x);
            }
            // 将自己加入
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}
