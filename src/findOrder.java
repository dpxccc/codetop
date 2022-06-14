import java.util.*;

/**
 * @Author diaopx
 * @Date 2022/6/14 10:59
 *
 * 210.课程包II
 **/
public class findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Map<Integer,List<Integer>> path = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            int src = p[1], det = p[0];
            // 目标的入度+1
            degree[det]++;
            List<Integer> list = path.getOrDefault(src, new ArrayList<>());
            list.add(det);
            path.put(src, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                // 将入度为0的值加入
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int src = queue.poll();
            ans[idx++] = src;
            // 将 该节点的 目标对象  的入度-1
            for (int det : path.getOrDefault(src, new ArrayList<>())) {
                degree[det]--;
                if (degree[det] == 0) {
                    queue.offer(det);
                }
            }
        }
        // 如果最后能够全部加入  说明拓扑排序成功
        return idx == numCourses ? ans : new int[]{};
    }
}
