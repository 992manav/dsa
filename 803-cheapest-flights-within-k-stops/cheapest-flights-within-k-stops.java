import java.util.*;

class Node {
    int node, dist;

    Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Graph banavanu adjacency list ma
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // flights data add karva
        for (int[] f : flights) graph[f[0]].add(new Node(f[1], f[2]));

        // dist array init karie → shuruaat ma infinite
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS queue use karva → koi PriorityQueue ni need nathi
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0));

        int stops = 0;
        // BFS ma level order traversal → ek level = ek stop
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (Node nei : graph[cur.node]) {
                    int to = nei.node, w = nei.dist;

                    // Relaxation logic: agar sasto path male to update karie
                    if (cur.dist + w < dist[to]) {
                        dist[to] = cur.dist + w;
                        q.add(new Node(to, dist[to]));
                    }
                }
            }
            stops++;
        }

        // ✅ Chutiya bana raha hai yeh question \U0001f923
        // Dijkstra jaisa lagse pehli vaar — kyanki shortest path + cost dikhai de
        // Pan asal ma bina Dijkstra bhi solve thai jaay chhe
        // Ahiya priority queue ni jarur nathi, simple BFS + relaxation enough chhe
        // Aa thi clear thayu ke Dijkstra ma PQ kyam use kare chhe (always min-cost node poll karva)
        // Pan aa problem ma to max 'k' stops limit chhe → BFS ni level order hi suffice kare chhe
        // Etle PQ ma level-order traversal na karva, simple queue + relaxation best chhe \U0001f60e

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
