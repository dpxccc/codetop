/**
 * @author diaopx
 * @date 2022/4/16 19:16
 * <p>
 * 165.比较版本号
 */
public class compareVersion {

    public int compareVersion(String version1, String version2) {
        int index01 = 0, index02 = 0;
        // 一个越界了则赋值为0
        while (index01 < version1.length() || index02 < version2.length()) {
            int a = 0;
            int b = 0;
            while (index01 < version1.length() && version1.charAt(index01) != '.') {
                a = a * 10 + version1.charAt(index01) - '0';
                index01++;
            }
            // 跳过下一个 .
            index01++;
            while (index02 < version2.length() && version2.charAt(index02) != '.') {
                b = b * 10 + version2.charAt(index02) - '0';
                index02++;
            }
            // 跳过 .
            index02++;
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        return 0;
    }
}
