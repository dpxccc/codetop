/**
 * @author diaopx
 * @date 2022/4/30 11:05
 * <p>
 * 191.位1的个数
 */
public class hammingWeight {

    public static void main(String[] args) {
        hammingWeight hammingWeight = new hammingWeight();
        System.out.println(hammingWeight.hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
