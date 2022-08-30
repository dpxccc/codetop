/**
 * @Author diaopx
 * @Date 2022/8/30 18:37
 *
 * 400.第N位数字
 **/
public class findNthDigit {

    public static void main(String[] args) {
        findNthDigit f = new findNthDigit();
        System.out.println(f.findNthDigit(13));
    }

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        // ch表示位数
        int ch = 1;
        long tmp = 9;
        long num = 0;
        while (num < n) {
            num += ch * tmp;
            ch++;
            tmp *= 10;
        }
        // 找到临界的位数和 数值
        ch--;
        num = num - ch * (tmp / 10);
        n -= num;
        // 起始位置
        int start = (int) Math.pow(10, ch - 1);
        start += (n - 1) / ch;
        int ans = 0;
        if (n % ch == 0) {
            return start % 10;
        }
        // 次数
        int x = ch - (n % ch);
        for (int i = 0; i <= x; i++) {
            ans = start % 10;
            start /= 10;
        }
        return ans;
    }
}
