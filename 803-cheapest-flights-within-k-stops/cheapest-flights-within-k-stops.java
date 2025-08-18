import java.util.*;

class Node {
    int node, dist;

    Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {

    int bellmanford(int n, int[][] edges, int src, int dst, int k) {
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {   // run k+1 times
            int[] temp = dist.clone();   // avoid overwriting in same round

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int w = edge[2];

                if (dist[from] != Integer.MAX_VALUE && dist[from] + w < temp[to]) {
                    temp[to] = dist[from] + w;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        return bellmanford(n, edges, src, dst, k);
    }
}
