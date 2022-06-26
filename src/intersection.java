import java.util.HashSet;
import java.util.Set;

/**
 * @Author diaopx
 * @Date 2022/6/26 11:56
 *
 * 349.两个数组的交集
 **/
public class intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] ans = new int[set2.size()];
        int i = 0;
        for (int x : set2) {
            ans[i++] = x;
        }
        return ans;
    }
}
