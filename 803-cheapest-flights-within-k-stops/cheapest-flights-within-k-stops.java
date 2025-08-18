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
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] f : flights) graph[f[0]].add(new Node(f[1], f[2]));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0));

        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (Node nei : graph[cur.node]) {
                    int to = nei.node, w = nei.dist;
                    if (cur.dist + w < dist[to]) {
                        dist[to] = cur.dist + w;
                        q.add(new Node(to, dist[to]));
                    }
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
