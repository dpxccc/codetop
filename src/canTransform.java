/**
 * @Author diaopx
 * @Date 2022/7/22 11:41
 **/
public class canTransform {

    public boolean canTransform(String start, String end) {
        if (!start.replaceAll("X", "").equals(end.replaceAll("X", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'X') continue;
            while (j < end.length() && end.charAt(j) == 'X') j++;
            if (i != j) {
                if (start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
