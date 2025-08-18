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

    @Override
    public int compareTo(Node other) {
        if (Integer.compare(this.level, other.level) == 0) {
            return this.dist - other.dist;
        } else {
            return this.level - other.level;
        }
    }
}

class Pair {
    int to;
    int w;

    Pair(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int w = flights[i][2];
            graph[from].add(new Pair(to, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.node;
            int level = cur.level;
            int cost = cur.dist;

            if (level > k) break;

            for (Pair neighbour : graph[node]) {
                int to = neighbour.to;
                int w = neighbour.w;

                if (dist[to] > cost + w) {
                    dist[to] = cost + w;
                    pq.add(new Node(to, level + 1, dist[to]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
