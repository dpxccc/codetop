import java.util.Arrays;

/**
 * @Author diaopx
 * @Date 2022/8/31 9:34
 * <p>
 * 670.最大交换
 **/
public class maximumSwap {

    // 贪心
    // 法一：num从大到小排序，和原来的num进行比较，第一个不同的数进行交换，注意如果有多个一样的数，选最后的位置进行交换
    // 法二：从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换。
    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];
        // 记录每个数字最后出现的位置
        for (int i = 0; i < array.length; i++) {
            lastIndex[array[i] - '0'] = i;
        }
        // 从左往右遍历array，找在当前位置右边的 最大数字，并交换
        for (int i = 0; i < array.length; i++) {
            // 最大的话，肯定是从9开始往前找，然后必须比当前数大
            for (int j = 9; j > array[i] - '0'; j--) {
                // 大数的索引 在 i之后，则把当前数和大数交换
                if (lastIndex[j] > i) {
                    swap(array, i, lastIndex[j]);
                    return Integer.parseInt(new String(array));
                }
            }
        }
        return num;
    }

    public void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
