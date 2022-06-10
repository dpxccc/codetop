/**
 * @author diaopx
 * @date 2022/5/24 20:00
 *
 * 287.寻找重复数
 */
public class findDuplicate {

    // 假设使用原地哈希
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        // 他的数是从 1 - n-1
        for (int i = 0; i < n; i++) {
            int index = nums[i] % n;
            nums[index] += n;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                ans = i;
            }
        }
        return ans;
    }

    public int findDuplicate(int[] nums) {
        /**
            快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
            注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
            因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
            即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while(true) {
            //两步和一步，找到环
            fast = nums[nums[fast]];
            slow = nums[slow];
            //slow和fast会在环中相遇，先假设一些量：起点到环的入口长度为m，环的周长为c，在fast和slow相遇时slow走了n步。则fast走了2n步，fast比slow多走了n步，而这n步全用在了在环里循环（n%c==0）。
// 当fast和last相遇之后，我们设置第三个指针finder，它从起点开始和slow(在fast和slow相遇处)同步前进，当finder和slow相遇时，就是在环的入口处相遇，也就是重复的那个数字相遇。
// 为什么 finder 和 slow 相遇在入口
// fast 和 slow 相遇时，slow 在环中行进的距离是n-m，其中 n%c==0。这时我们再让 slow 前进 m 步——也就是在环中走了 n 步了。而 n%c==0 即 slow 在环里面走的距离是环的周长的整数倍，就回到了环的入口了，而入口就是重复的数字。
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    //     /**
//      * 二分查找，数组长度为n。因为存在重复数tar，且都是1-(n-1)之间的数，
//      * 整个num数组中1 - tar之间的数的个数应该<=tar
//      */
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;
//         int left = 1,right = n -1;
//         while(left < right){
//             int mid = left + (right - left)/2;
//             int count = 0;
//             for(int num : nums){
//                 if(num <= mid){
//                     count++;
//                 }
//             }
//             //判断count和当前mid的大小
//             if(count <= mid){
//                 left = mid + 1;
//             }else{
//                 right = mid;
//             }
//         }
//         return left;
//     }

}



