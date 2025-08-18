import java.util.*;

class Solution {

    // Node class banayi jisme neighbour aur us tak ki distance store hogi
    class Node implements Comparable<Node> {
        int v;      // destination node
        int dist;   // distance from source tak

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            // priority queue me chhoti distance wala pehle niklega
            return this.dist - other.dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // pehle graph banao adjacency list ke through
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Node(v, w)); // u -> v with weight w
        }

        // distance array banao aur sabko initially infinity karo
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // src ki distance 0 hogi

        // visited array bhi banao taaki ek node dobara process na ho
        boolean[] visited = new boolean[n + 1];

        // priority queue banao distance ke hisaab se sort hone wali
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0)); // source node daal do

        // ab Dijkstra algorithm start karo
        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // sabse chhoti distance wala nikalo
            int u = cur.v;

            if (visited[u]) continue; // agar already visited hai to skip karo
            visited[u] = true;        // warna mark visited

            // ab neighbours check karo aur relaxation lagao
            for (Node nei : graph.get(u)) {
                if (dist[u] + nei.dist < dist[nei.v]) {
                    dist[nei.v] = dist[u] + nei.dist;
                    pq.add(new Node(nei.v, dist[nei.v]));
                }
            }
        }

        // finally dist array ka max value nikalo (sabse late pahunchne wala node)
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // agar koi node unreachable hai
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
