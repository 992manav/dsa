class Solution {

    boolean[] visited;
    boolean[] safe;

    boolean dfs(int[][] graph, int node) {
        visited[node] = true;

        if (graph[node].length == 0) {
            safe[node] = true;
            return true;
        }

        for (int j = 0; j < graph[node].length; j++) {
            int neighbour = graph[node][j];

            if (visited[neighbour]) {
                if (!safe[neighbour]) {
                    return false;
                }
            } else {
                if (!dfs(graph, neighbour)) {
                    return false;
                }
            }
        }

        safe[node] = true;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        visited = new boolean[n];
        safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
