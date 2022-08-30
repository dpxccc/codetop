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
        //先找到n在哪一个数字里，再寻找第n位是哪个数
        //每一个位数的总共数字个数有9,90,900即Math.pow(10,i-1)*9*i
        int i = 1;
        while (9 * Math.pow(10, i - 1) * i < n) {
            n -= 9 * Math.pow(10, i - 1) * i;
            i++;
        }
        //如果正好结束，说明就是刚刚的最后一位数的最后一位，就是9,99,999等等
        if (n == 0) {
            return 9;
        }
        //下一位的开头
        int x = (int) Math.pow(10, i - 1);
        //剩余的数字在i位数中占了多少个
        int s = n / i;
        int mod = n % i;
        //这儿的x <= 目标数，如果mod是0，说明就是x的最后一位，否则就是x+1 从左往右数的第mod位
        x += s - 1;
        return mod == 0 ? x % 10 : (x + 1) / (int) (Math.pow(10, i - mod)) % 10;


        //如果mod==0，说明就是刚刚的最后一位
        // if (mod == 0) {
        //     //因为包含了10,100,1000等，所以要减一
        //     return (x + s - 1) % 10;
        // }
        // //mod>0说明第n位在下一个数字中
        // x += s;
        // int temp = i - mod;
        // while (temp-- != 0) {
        //     x /= 10;
        // }
        // return x % 10;

    }

    public int findNthDigit1(int n) {
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
