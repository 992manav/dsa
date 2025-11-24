import java.util.*;

class Solution {

    static class Pair {
        int node;
        int cost;
        Pair(int n, int c) {
            node = n;
            cost = c;
        }
    }

    List<Pair>[] graph;
    int n;
    long K;
    int target;
    List<Integer> topo;

    boolean check(int minEdge) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == Long.MAX_VALUE) continue;

            List<Pair> list = graph[u];
            for (int i = 0; i < list.size(); i++) {
                Pair p = list.get(i);

                if (p.cost < minEdge) continue;

                long nd = dist[u] + p.cost;
                if (nd < dist[p.node]) dist[p.node] = nd;
            }
        }

        return dist[target] <= K;
    }

    List<Integer> topological(int n, List<Integer>[] g) {

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            for (int v : g[i]) in[v]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (in[i] == 0) q.add(i);

        List<Integer> ts = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            ts.add(u);
            for (int v : g[u]) {
                in[v]--;
                if (in[v] == 0) q.add(v);
            }
        }

        return ts;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        K = k;
        n = online.length;
        target = n - 1;

        graph = new ArrayList[n];
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            g[i] = new ArrayList<>();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int c = edges[i][2];

            if (online[u] && online[v]) {
                graph[u].add(new Pair(v, c));
            }

            g[u].add(v);

            if (c < min) min = c;
            if (c > max) max = c;
        }

        topo = topological(n, g);

        int low = min;
        int high = max;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
