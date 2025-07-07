class Solution {

    void dfs(int[][] graph, boolean[] visited, int node) {
        if (!visited[node]) {
            visited[node] = true;

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    dfs(graph, visited, i);
                }
            }
        }
    }

    public int findCircleNum(int[][] graph) {
        int count = 0;

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }
}
