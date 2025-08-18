import java.util.*;

class Node implements Comparable<Node> {
    int node, level, dist;

    Node(int node, int level, int dist) {
        this.node = node;
        this.level = level;
        this.dist = dist;
    }

    Node(int node, int dist) {
        this(node, 0, dist);
    }

    @Override
    public int compareTo(Node other) {
        int cmp = Integer.compare(this.level, other.level);
        return (cmp == 0) ? Integer.compare(this.dist, other.dist) : cmp;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] f : flights) graph[f[0]].add(new Node(f[1], f[2]));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));

        int level = 0;
        while (!pq.isEmpty() && level <= k) {
            int len = pq.size();
            while (len-- > 0) {
                Node cur = pq.poll();
                int node = cur.node, cost = cur.dist;

                for (Node nei : graph[node]) {
                    int to = nei.node, w = nei.dist;
                    if (cost + w < dist[to]) {
                        dist[to] = cost + w;
                        pq.add(new Node(to, level + 1, dist[to]));
                    }
                }
            }
            level++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
