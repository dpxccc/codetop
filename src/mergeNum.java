/**
 * @author diaopx
 * @date 2022/4/17 15:31
 * <p>
 * 88.合并两个有序数组
 */
public class mergeNum {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        // 只需要保证j >= 0 即可，如果j < 0，nums2已经全部插入nums1了，那么剩下的i还是在nums1[i]的原位上
        while (j >= 0) {
            if (i < 0 || nums1[i] <= nums2[j]) {
                nums1[last--] = nums2[j--];
            } else {
                nums1[last--] = nums1[i--];
            }
        }
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        // 只需要保证j >= 0 即可，如果j < 0，nums2已经全部插入nums1了，那么剩下的i还是在nums1[i]的原位上
        while (j >= 0 && i >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[last--] = nums2[j--];
            } else if (nums1[i] > nums2[j]) {
                nums1[last--] = nums1[i--];
            } else if (nums1[i] == nums2[j]) {
                nums1[last--] = nums1[i--];
                j--;
            }
        }
        while (i >= 0) {
            nums1[last--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[last--] = nums2[j--];
        }
        // last + 1 开始
        for (int k = last + 1; k < m + n; k++) {
            System.out.println(nums1[k]);
        }
    }
}
