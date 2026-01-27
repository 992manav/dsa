import java.util.*;

class Solution {

    int max_sum = 0;
    int n;
    int[] values;
    List<int[]>[] graph;

    void dfs(int node, boolean[] visited, int timeLeft, int cur_sum) {

        // Add current node's value if not visited yet
        boolean wasVisited = visited[node];
        if (!wasVisited) {
            cur_sum += values[node];
            visited[node] = true;
        }

        // Update max_sum whenever we're at node 0
        if (node == 0) {
            max_sum = Math.max(max_sum, cur_sum);
        }

        // Explore neighbors
        for (int[] edge : graph[node]) {
            int neighbor = edge[0];
            int time = edge[1];
            
            if (timeLeft >= time) {
                dfs(neighbor, visited, timeLeft - time, cur_sum);
            }
        }

        // Backtrack: unmark visited only if we marked it in this call
        if (!wasVisited) {
            visited[node] = false;
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

        this.values = values;
        n = values.length;

        // Build adjacency list
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n];

        dfs(0, visited, maxTime, 0);

        return max_sum;
    }
}