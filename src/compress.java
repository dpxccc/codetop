/**
 * @Author diaopx
 * @Date 2022/8/31 11:02
 * <p>
 * 443.压缩字符串
 **/
public class compress {

    public int compress(char[] chars) {
        int ans = 0;
        int n = chars.length;
        int i = 0;
        while (i < n) {
            int j = i;
            int num = 0;
            // 寻找数量
            while (j < n && chars[i] == chars[j]) {
                num++;
                j++;
            }
            if (num == 1) {
                // 修改chars数组
                chars[ans++] = chars[i];
            } else {
                chars[ans++] = chars[i];
                int x = ans;
                while (num != 0) {
                    chars[ans++] = (char) (num % 10 + '0');
                    num /= 10;
                }
                reverse(chars, x, ans - 1);
            }
            i = j;
        }
        return ans;
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
