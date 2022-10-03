/**
 * @Author diaopx
 * @Date 2022/10/3 14:35
 * <p>
 * 927.三等分
 **/
public class threeEqualParts {

    public static void main(String[] args) {
        threeEqualParts t = new threeEqualParts();
        System.out.println(t.threeEqualParts(new int[]{1, 0, 1, 1, 0}));
    }

    // 1的个数必须是3的倍数，每个部分1的个数必须相等，且在相同位置
    // 并根据后导0来找到分割点的位置。不能用前导0，因为前导0不影响数的大小，前面加多少个0都可以，但是后导0会影响数的大小，个数必须相同
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i : arr) {
            cnt += i;
        }
        if (cnt == 0) return new int[]{0, 2};
        if (cnt % 3 != 0) return new int[]{-1, -1};
        // 先求最后一个的后导0个数
        int suffix0 = 0;
        for (int i = n - 1; i >= 0 && arr[i] == 0; i--) {
            suffix0++;
        }
        int x = cnt / 3;
        cnt = 0;
        String[] tmp = new String[3];
        int[] index = new int[2];
        int idx = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            cnt += arr[i];
            // 只计算前两个区间， 第三个在下面计算
            if (cnt == x && num < 2) {
                cnt = 0;
                num++;
                // 记录1的位置之后还要加上后导0
                index[idx] = i + suffix0;
                // 需要从加上 suffix0 的位置开始，如果有1那就错误
                // 这个for循环可以不需要，因为如果从i+suffix0开始 往前寻找的话，如果是1，那就不相等了
                for (int j = 1; j <= suffix0; j++) {
                    if (arr[i + j] == 1) return new int[]{-1, -1};
                }
                tmp[idx++] = getNum(arr, x, i + suffix0);
            }
        }
        // 最后一个从n-1开始
        tmp[2] = getNum(arr, x, n - 1);
        if (tmp[0].equals(tmp[1]) && tmp[0].equals(tmp[2])) {
            return new int[]{index[0], index[1] + 1};
        }
        return new int[]{-1, -1};
    }

    /**
     * 从尾部开始向前构建string
     */
    public String getNum(int[] arr, int x, int i) {
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            sb.append(arr[i]);
            if (arr[i--] == 1) {
                x--;
            }
        }
        return sb.toString();
    }
}
