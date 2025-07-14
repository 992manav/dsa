class Solution {

    boolean dfs(int[][] graph, boolean[] visited, boolean[] inPath, int node) {
        visited[node] = true;
        inPath[node] = true;

        for (int j = 0; j < graph[node].length; j++) {
            if (graph[node][j] == 1) {
                if (!visited[j]) {
                    if (!dfs(graph, visited, inPath, j)) {
                        return false;
                    }
                } else if (inPath[j]) {
                    return false; // Cycle found
                }
            }
        }

        inPath[node] = false;
        return true;
    }

    public boolean canFinish(int n, int[][] edge) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][1];
            int to = edge[i][0];
            
            graph[from][to] = 1;
        }

        boolean[] visited = new boolean[n];
        boolean[] inPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(graph, visited, inPath, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
