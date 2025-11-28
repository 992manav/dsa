import java.util.*;

class Solution {

    int k;
    long[] values;
    ArrayList<Integer>[] graph;
    int count;
    int[] indegree;
    int n;

    int bfs(Queue<Integer> q) {
        boolean[] removed = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            removed[node] = true;

            List<Integer> lst = graph[node];
            int parent = -1;

            for (int i = 0; i < lst.size(); i++) {
                int neighbour = lst.get(i);
                if (!removed[neighbour]) parent = neighbour;
            }

            if (parent == -1) {
                if (values[node] % k == 0) count++;
                continue;
            }

            indegree[parent]--;

            if (values[node] % k == 0) count++;
            else values[parent] += values[node];

            if (indegree[parent] == 1) q.offer(parent);
        }

        return count;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {

        if (n == 1) return 1;

        this.k = k;
        this.n = n;

        values = new long[n];
        for (int i = 0; i < n; i++) values[i] = vals[i];

        indegree = new int[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) q.offer(i);
        }

        return bfs(q);
    }
}
