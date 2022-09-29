/**
 * @Author diaopx
 * @Date 2022/9/29 9:24
 * <p>
 * 4.寻找两个正序数组的中位数
 **/
public class findMedianSortedArrays {

    // 比较两个数组 k/2 的位置，然后删去小的区间，并且k-删去的个数。重新从下一个位置开始比较k/2的位置
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 两个中位数  奇数个也是两个相同的
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    }

    public int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        // 如果len1大于len2  就交换 保证数组空的时候一定是len1
        if (len1 > len2) return getKth(nums2, s2, e2, nums1, s1, e1, k);
        // 如果一个数组为空了，那么中位数就是另一个数组剩下的序列中的第k（这个k可能已经改变过了）个
        if (len1 == 0) return nums2[s2 + k - 1];
        // 只需要比 k=1 个数时  取两者的小值
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        // 找当前序列的第 k/2 个
        int i = s1 + Math.min(len1, k / 2) - 1;
        int j = s2 + Math.min(len2, k / 2) - 1;
        // 说明nums1中的数可能是中位数，但是nums2中的前j个数不能是中位数
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        } else {
            // 从nums1的下一个位置开始，并且k需要减去相应的个数
            return getKth(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        }
    }
}
