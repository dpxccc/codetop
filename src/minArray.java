/**
 * @Author diaopx
 * @Date 2022/6/22 18:27
 *
 * 剑指offer11 旋转数组的最小数字
 **/
public class minArray {


    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[left]){
                right = mid;
            } else {
                // 中间值和右边相等时   有两个情况
                right--;
            }
        }
        return numbers[left];
    }
}
