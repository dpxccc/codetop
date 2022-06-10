import java.util.*;

/**
 * @author diaopx
 * @date 2022/4/5 15:52
 * <p>
 * 310.最小高度树
 */
public class findMinHeightTrees {

    /**
     * 最小高度树的根节点一定存在其最长路径上。假设节点路径依次为p1,p2,p3...pm，最长路径是m-1。
     * 如果结点数m是偶数，则最终的节点为m/2和m/2+1
     * 如果结点数m是奇数，则最终的节点为p(m+1)/2
     * <p>
     * 找到图中距离最远的两个节点与它们之间的路径：
     * 以任意节点 p 出现，利用广度优先搜索或者深度优先搜索找到以 p 为起点的最长路径的终点 x；
     * 以节点 x 出发，找到以 x 为起点的最长路径的终点 y；
     * x 到 y 之间的路径即为图中的最长路径，找到路径的中间节点即为根节点。
     */

    int n;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        int len = edges.length;

        // 构建树
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            path.add(list);
        }
        for (int i = 0; i < len; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            path.get(start).add(end);
            path.get(end).add(start);
        }
        // 记录经过节点的上一个节点，最后可以根据该数组寻找路径
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        List<Integer> ans = new ArrayList<>();
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, path);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, path);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> view = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            view.add(y);
            y = parent[y];
        }
        int m = view.size();
        if (m % 2 == 0) {
            ans.add(view.get(m / 2 - 1));
        }
        ans.add(view.get(m / 2));
        return ans;
    }

    /**
     * 找到离start节点最远的一个节点
     */
    public int findLongestNode(int start, int[] parent, List<List<Integer>> path) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 记录节点的访问情况，防止重复访问
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        // 记录最后的节点
        int node = -1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            node = cur;
            List<Integer> list = path.get(cur);
            // 将下一节点加入
            for (int next : list) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    // 下一节点的  parent就是cur
                    parent[next] = cur;
                }
            }
        }
        return node;
    }

    /*int n;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        this.n = n;
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int len = edges.length;
        List<Integer>[] path = new List[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            path[start].add(end);
            path[end].add(start);
        }
        // 记录经过节点的上一个节点，最后可以根据该数组寻找路径
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        *//* 找到与节点 0 最远的节点 x *//*
        int x = findLongestNode(0, path, parent);
        *//* 找到与节点 x 最远的节点 y *//*
        int y = findLongestNode(x, path, parent);
        *//* 求出节点 x 到节点 y 的路径 *//*
        List<Integer> view = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            view.add(y);
            y = parent[y];
        }
        int m = view.size();
        if (m % 2 == 0) {
            ans.add(view.get(m / 2 - 1));
        }
        ans.add(view.get(m / 2));
        return ans;
    }

    private int findLongestNode(int start, List<Integer>[] path, int[] parent) {
        // 记录每个经过的节点的步数
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        dfs(start, path, parent, dist);
        int maxD = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if(dist[i] > maxD){
                maxD = dist[i];
                node = i;
            }
        }
        // 距离start最远距离的节点
        return node;
    }

    private void dfs(int start, List<Integer>[] path, int[] parent, int[] dist) {
        for (int next : path[start]) {
            // 小于0  说明该位置没有被遍历过
            if (dist[next] < 0) {
                // 上一步  +1
                dist[next] = dist[start] + 1;
                parent[next] = start;
                dfs(next, path, parent, dist);
            }
        }
    }*/
}
