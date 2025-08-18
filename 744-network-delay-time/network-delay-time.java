import java.util.*;

class Solution {

    // Bellman-Ford function
    int bellman_ford(int[][] edges, int n, int src) {
        int[] dist = new int[n + 1]; // 1-based indexing
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int w = edge[2];

                if (dist[from] != Integer.MAX_VALUE && dist[from] + w < dist[to]) {
                    dist[to] = dist[from] + w;
                }
            }
        }

        // agar koi node unreachable hai to -1 return karo
        int maxVal = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxVal = Math.max(maxVal, dist[i]);
        }
        return maxVal;
    }

    public int networkDelayTime(int[][] edges, int n, int k) {
        return bellman_ford(edges, n, k);
    }
}
