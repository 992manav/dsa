import java.util.*;

class Solution {

    int[] visited;

    boolean dfs(int node, Set<Integer> curr_set, Set<Integer> opp_set, int[][] graph) {
        visited[node] = 1;
        curr_set.add(node);

        for (int j : graph[node]) {
            if (curr_set.contains(j)) {
                return false;
            }

            if (!opp_set.contains(j)) {
                opp_set.add(j);
                if (!dfs(j, opp_set, curr_set, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, set1, set2, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}
