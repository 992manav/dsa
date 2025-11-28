import java.util.*;

class Solution {

    int k;
    int[] values;
    ArrayList<Integer>[] graph;

    long dfs(int node, int parent, int[] ans) {

        long sum = values[node];

        for (int child : graph[node]) {
            if (child == parent) continue;

            long childSum = dfs(child, node, ans);
            sum += childSum;
        }

        if (sum % k == 0) {
            ans[0]++;
            return 0;
        }

        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        this.k = k;
        this.values = values;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] ans = new int[1];

        dfs(0, -1, ans);

        return ans[0];
    }
}
