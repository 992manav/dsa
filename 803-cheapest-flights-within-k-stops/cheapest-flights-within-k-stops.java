import java.util.*;

class Node implements Comparable<Node> {
    int node;
    int level;
    int dist;

    Node(int node, int level, int dist) {
        this.node = node;
        this.level = level;
        this.dist = dist;
    }

    Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
        this.level = 0;
    }

    @Override
    public int compareTo(Node other) {
        if (Integer.compare(this.level, other.level) == 0) {
            return this.dist - other.dist;
        } else {
            return this.level - other.level;
        }
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            int from = f[0], to = f[1], w = f[2];
            graph[from].add(new Node(to, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));

        int level = 0;
        while (!pq.isEmpty()) {
            if (level > k) break;

            int len = pq.size();
            for (int i = 0; i < len; i++) {
                Node cur = pq.poll();
                int node = cur.node;
                int cost = cur.dist;

                for (Node nei : graph[node]) {
                    int to = nei.node;
                    int w = nei.dist;

                    if (dist[to] > cost + w) {
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
