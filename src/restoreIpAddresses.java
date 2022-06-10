import java.util.ArrayList;
import java.util.List;

/**
 * @author diaopx
 * @date 2022/4/25 11:21
 * <p>
 * 93.复原IP地址
 */
public class restoreIpAddresses {

    public static void main(String[] args) {
        restoreIpAddresses r = new restoreIpAddresses();
        System.out.println(r.restoreIpAddresses("101023"));
    }

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return ans;
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int dotNum, int start) {
        if (dotNum == 3) {  // 三个点就分割完成
            // 判断第四个是否满足要求
            if (isValid(s, start, s.length() - 1)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 判断该次拆分是否满足要求
            if (isValid(s, start, i + 1)) {
                // 拆分字符串0 - i 和 i+1 - 最后，中间加个 .
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                dfs(s, dotNum + 1, i + 2);
                // 回溯   恢复 字符串s
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                // 不满足要求  则直接跳出本次循环，后面的也不会满足
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 不止一个数字  并且首位为0
        if (start != end && s.charAt(start) == '0') {
            return false;
        }
        // 计算该区间内的大小
        int num = Integer.parseInt(s.substring(start, end + 1));
        if (num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }
}
