class Solution {

    boolean[] visited;
    boolean[] terminal;
    boolean[] safe;

    boolean dfs(int[][] graph, int node) {

        visited[node] = true;

        if (terminal[node]) {
            safe[node] = true;
            return true;
        }

        for (int j = 0; j < graph[node].length; j++) {
            int neighbour = graph[node][j];

            if (visited[neighbour]) {

                if (safe[neighbour]) {
                    continue;
                } else {
                    return false;
                }

            } else {

                if (safe[neighbour]) {
                    continue;
                } else {
                    if (!dfs(graph, neighbour)) {
                        return false;
                    }
                }
            }
        }

        safe[node] = true;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        visited = new boolean[graph.length];
        terminal = new boolean[graph.length];
        safe = new boolean[graph.length];

        for (int i = 0; i < terminal.length; i++) {
            if (graph[i].length == 0) {
                terminal[i] = true;
            } else {
                terminal[i] = false;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < safe.length; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
