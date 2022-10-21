import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author diaopx
 * @Date 2022/10/21 14:56
 *
 * 1353.最多可以参加的会议数
 **/
public class maxEvents1353 {

    /**
     * 1.按照结束时间排序。先将结束时间早的安排好 （最终超时） 例如(1,5) (1,5) (1,5) (2,3)  先安排1,5的话，会占据123,  先安排2,3  只会先占据2, (1,5)会从1到5找
     * 2.首先，对会议按照开始时间升序排列，排序的目的是为了可以方便的一起选择开始时间相同的会议
     *   然后从第 1 天开始，依次判断每一天是否可以参加会议，记当天为 currDay ，从第 1 天开始
     *   顺序遍历会议，将开始时间等于 currDay 的会议的结束时间放入小顶堆
     *   将堆顶结束时间小于 currDay 的会议从堆中删除，这些会议都是过时的，参加不到的会议
     *   如果堆不为空，则选择会议结束时间最小的会议参加，表示 currDay 这一天可以参加会议
     *   currDay 往后走一天，判断下一天是否可以参加会议
     */
    public int maxEvents(int[][] events) {
        int n = events.length;
        // 按照 开始时间 排序  先开始的安排好，后面再安排开始晚的  相同开始时间的先安排，结束晚一点的能够安排更多的时间
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // 按照 结束时间 排序
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, ans = 0;
        // 依次判断每一天能否安排会议
        int curDay = 1;
        while (i < n || !pq.isEmpty()) {
            //  将所有开始时间等于 curDay 的会议的结束时间放到小顶堆
            while (i < n && events[i][0] == curDay) {
                pq.offer(events[i][1]);
                i++;
            }
            // 删除会议结束时间已经小于curDay的所有数，这些都安排不了了
            while (!pq.isEmpty() && pq.peek() < curDay) {
                pq.poll();
            }
            // 弹出第一个结束时间，该会议就安排在这一天
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
            // 继续下一天
            curDay++;
        }
        return ans;
    }
}
