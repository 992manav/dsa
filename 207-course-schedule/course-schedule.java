import java.util.*;

class Solution {

    boolean dfs(List<List<Integer>> graph, boolean[] visited, boolean[] inPath, int node) {
        visited[node] = true;
        inPath[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(graph, visited, inPath, neighbor)) {
                    return false;
                }
            } else if (inPath[neighbor]) {
                return false; // Cycle detected
            }
        }

        inPath[node] = false;
        return true;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]); // edge[1] → edge[0]
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
