import java.util.*;

/**
 * @Author diaopx
 * @Date 2022/6/10 19:26
 * <p>
 * 207.课程表
 **/
public class canFinish {

    public static void main(String[] args) {
        canFinish c = new canFinish();
        int[][] prerequisites = {{1, 0}};
        System.out.println(c.canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        // 该课是哪些课的前置课程
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 计算每个节点的 入度
        int[] degree = new int[numCourses];
        for (int i = 0; i < n; i++) {
            int det = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = map.getOrDefault(src, new ArrayList<>());
            list.add(det);
            degree[det]++;
            map.put(src, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int visit = 0;
        while (!queue.isEmpty()) {
            visit++;
            int tmp = queue.poll();
            // 可能存在没有用过的节点, 例如有3节课  只有2节之间有前后要求
            for (int x : map.getOrDefault(tmp, new ArrayList<>())) {
                degree[x]--;
                if (degree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        return visit == numCourses;
    }
}
