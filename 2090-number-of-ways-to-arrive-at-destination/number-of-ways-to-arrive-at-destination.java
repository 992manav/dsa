import java.util.*;  // ✅ required imports

class Pair implements Comparable<Pair> {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair other) {
        return this.dist - other.dist;
    }
}

class Solution {
    static final int MOD = 1_000_000_007;  // ✅ mod constant

    public int countPaths(int n, int[][] edges) {
        // undirected some -> not fully connected
        // n nodes
        // connected hai → har node se har node tak path exist karta hai
        // 0th node se n-1 node minimum amount of time mein pahunchna hai 

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];

            graph[from].add(new Pair(to, w));
            graph[to].add(new Pair(from, w));
        }

        // Pair to isliye taaki dist ke base pe minimum time se compare kare priority queue mein baaki koi kaam nahi hai 
        long[][] dist = new long[n][2];   // ✅ long use to avoid overflow

        for (int i = 0; i < n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = 0;
        }

        dist[0][0] = 0; // ✅ source node distance should be 0
        dist[0][1] = 1; // ✅ source ke liye ek hi path hai initially

        boolean[] visited = new boolean[n];
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int node = p.node;

            if (!visited[node]) {
                visited[node] = true;
                List<Pair> lst = graph[node];

                for (Pair neigh : lst) {
                    int neighbor = neigh.node; 
                    int w = neigh.dist;

                    if (dist[node][0] + w <= dist[neighbor][0]) {  
                        if (dist[node][0] + w == dist[neighbor][0]) {
                            dist[neighbor][1] = (dist[neighbor][1] + dist[node][1]) % MOD;  // ✅ mod add
                        }

                        if (dist[node][0] + w < dist[neighbor][0]) {
                            dist[neighbor][0] = dist[node][0] + w;
                            dist[neighbor][1] = dist[node][1] % MOD;  // ✅ mod add
                        }
                        
                        pq.add(new Pair(neighbor, (int) dist[neighbor][0])); 
                    }
                }
            }
        }

        return (int)(dist[n-1][1] % MOD);  // ✅ final mod return
    }
}
