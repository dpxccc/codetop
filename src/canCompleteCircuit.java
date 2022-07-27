/**
 * @Author diaopx
 * @Date 2022/7/27 11:02
 *
 * 134.加油站
 **/
public class canCompleteCircuit {

    // 假设0~k站的剩余油量为res0，而2~k站的剩余油量为res2，则有res0-res2=[0]+[1]；
    // 因为车是能从0开到k的所以车一定能从0开到1，也就是说[0]+[1]>=0，也就能得到res0>=res2，
    // 因此可以得到从0~k站要比2~k站的剩余油量要多；以此类推0~k站的剩余油量一定是最多的
    // 不是从k开始，因为在k - k+1 时消耗太多导致整体小于0，所以当前一定有gas < cost

    // 为什么k+1->end全部可以正常通行，且rest>=0就可以说明车子从k+1站点出发可以开完全程
    // 个人理解：因为前面存在了run < 0 所以rest在没有找到正确的点时一直小于0，前面整体缺少的油为x ，
    // 而从start开始，在整体rest<0的情况下，是的最终rest>=0，所以从start开始遍历到最后的油量一定y > x，就可以弥补前面缺少的油x
    // 重点   start 右边的油量  >= 左边缺少的油量
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, run = 0, rest = 0;
        for (int i = 0; i < gas.length; i++) {
            // 总和必须大于等于0，否则不能完成绕行
            run += gas[i] - cost[i];
            rest += gas[i] - cost[i];
            if (run < 0) {
                // 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个。
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }
}
