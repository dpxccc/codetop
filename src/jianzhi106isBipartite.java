import java.util.ArrayList;
import java.util.List;

/**
 * @Author diaopx
 * @Date 2022/12/28 19:44
 * <p>
 * 剑指offerII 106
 **/
public class jianzhi106isBipartite {

    int[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<Integer>[] path = new List[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                path[i].add(graph[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && !dfs(path, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] path, int c, int x) {
        if (visited[x] != 0) {
            return visited[x] == c;
        }
        visited[x] = c;
        for (int y : path[x]) {
            if (!dfs(path, 3 - c, y)) {
                return false;
            }
        }
        return true;
    }
}
