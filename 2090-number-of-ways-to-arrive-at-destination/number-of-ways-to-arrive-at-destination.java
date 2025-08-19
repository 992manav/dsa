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

        // Pair isliye taaki dist ke base pe minimum time se
        // compare kare priority queue mein,
        // baaki koi kaam nahi hai 
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
                            // jab equal aajaye toh add karo
                            // → jaha se aaya uske ways
                            // + abhi tak idhar pahunchne ke ways
                            dist[neighbor][1] = 
                                (dist[neighbor][1] + dist[node][1]) % MOD; 
                        }

                        if (dist[node][0] + w < dist[neighbor][0]) {    
                            // jab kam aaye kisi node pe aane ka distance
                            // from source → to uske aane ke ways
                            // ab jaha se kam aaya woh node pe nirbhar karenge directly 
                            
                            // jab kam aaye toh jiski wajah se kam aaya hai distance,
                            // us node ke jaane ke jitne ways hain
                            // ab is node ke bhi utne hi ways ho jaayenge. 
                            // Purane jo ways the yeh node pe pahunchne ke par
                            // woh distance zyada le rahe the,
                            // isliye unko hatao aur ab isko hi ginno
                            
                            dist[neighbor][0] = dist[node][0] + w;
                            dist[neighbor][1] = dist[node][1] % MOD; 
                        }
                        
                        pq.add(new Pair(neighbor, (int) dist[neighbor][0])); 
                    }
                }
            }
        }

        return (int)(dist[n-1][1] % MOD);  
    }
}
