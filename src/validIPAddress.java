/**
 * @author diaopx
 * @date 2022/5/9 10:36
 *
 * 468.验证IP地址
 */
public class validIPAddress {

    public static void main(String[] args) {
        System.out.println("12..33.4".split("\\.").length);
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.length() < 1 || queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':' ||
                queryIP.charAt(queryIP.length() - 1) == '.' || queryIP.charAt(queryIP.length() - 1) == ':') {
            return "Neither";
        }
        // 判断是不是 IPv4 类型的
        if (queryIP.contains(".")) {
            String[] arr = queryIP.split("\\.");
            // 长度不对   两个都包含了
            if (arr.length != 4 || queryIP.contains(":")) {
                return "Neither";
            }
            for (int i = 0; i < arr.length; i++) {
                // 判断每一段的长度
                if (arr[i].equals("") || arr[i].length() < 1 || arr[i].length() > 3) {
                    return "Neither";
                }
                // 前导0
                if (arr[i].length() > 1 && arr[i].charAt(0) == '0') {
                    return "Neither";
                }
                for (int j = 0; j < arr[i].length(); j++) {
                    // 拆分的字符串中 包含了  不是数字的情况
                    if (!Character.isDigit(arr[i].charAt(j))) {
                        return "Neither";
                    }
                }
                int val = Integer.parseInt(arr[i]);
                if (val < 0 || val > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            // 是用 : 进行分隔的，IPv6
            String[] arr = queryIP.split(":");
            // 长度不对
            if (arr.length != 8 || queryIP.contains(".")) {
                return "Neither";
            }
            // 遍历每个字符串，判断是否满足条件
            for (int i = 0; i < arr.length; i++) {
                // 长度在 1 - 4之间
                if (arr[i].length() < 1 || arr[i].length() > 4) {
                    return "Neither";
                }
                for (int j = 0; j < arr[i].length(); j++) {
                    char ch = arr[i].charAt(j);
                    // 满足条件的跳过
                    if (Character.isDigit(ch) || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f')) {
                        continue;
                    }
                    // 不满足条件
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}
