/**
 * @Author diaopx
 * @Date 2022/11/14 10:03
 * <p>
 * 440.字典序的第k小数字
 **/
public class a440findKthNumber {

    public int findKthNumber(int n, int k) {
        int p = 1;
        int prefix = 1;
        while (p < k) {
            int count = getNums(n, prefix);
            // 不在当前前缀下
            if (p + count < k + 1) {
                p += count;
                prefix++;
            } else {
                // 在当前前缀下
                prefix *= 10;
                p++;
            }
        }
        return prefix;
    }

    // 计算当前前缀下 小于等于 n 的个数
    public int getNums(int n, int prefix) {
        int cnt = 0;
        long next = prefix + 1;
        long cur = prefix;
        while (cur <= n) {
            cnt += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }
}
