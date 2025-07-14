class Solution {

    boolean dfs(int[][] graph, boolean[] visited, boolean[] is_in_my_path, int node) {

        visited[node] = true;
        is_in_my_path[node] = true;

        for (int j = 0; j < graph[node].length; j++) {
            if (graph[node][j] == 1) {
                if (visited[j]) {
                    if (is_in_my_path[j]) {
                        return false;
                    }
                } else {
                    if (!dfs(graph, visited, is_in_my_path, j)) {
                        return false;
                    }
                }
            }
        }

        is_in_my_path[node] = false;
        return true;

    }

    public boolean canFinish(int n, int[][] edge) {

        // DAG nu ultu

        int[][] graph = new int[n][n];

        // yaa toh undirected edge haoy  
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][1];
            int to = edge[i][0];

            if (graph[to][from] == 1) {
                return false;
            } else {
                graph[from][to] = 1;
            }
        }

        boolean[] visited = new boolean[n];
        boolean[] is_in_my_path = new boolean[n];

        // yaa to cycle hoy  
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                if (!dfs(graph, visited, is_in_my_path, i)) {
                    return false;
                }
            }
        }

        return true;
    }

}
