import java.util.*;

class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {

    public int minCost(int n, int[][] edges) {

        Map<Integer, Integer>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (!graph[u].containsKey(v)) {
                graph[u].put(v, w);
            } else {
                graph[u].put(v, Math.min(graph[u].get(v), w));
            }

            if (!graph[v].containsKey(u)) {
                graph[v].put(u, 2 * w);
            } else {
                graph[v].put(u, Math.min(graph[v].get(u), 2 * w));
            }
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];

        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            int node = p.node;

            if (visited[node]) continue;
            visited[node] = true;

            for (Map.Entry<Integer, Integer> e : graph[node].entrySet()) {
                int nei = e.getKey();
                int wt = e.getValue();

                if (!visited[nei] && dist[node] + wt < dist[nei]) {
                    dist[nei] = dist[node] + wt;
                    pq.add(new Pair(nei, dist[nei]));
                }
            }
        }

        if (dist[n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[n - 1];
    }
}
