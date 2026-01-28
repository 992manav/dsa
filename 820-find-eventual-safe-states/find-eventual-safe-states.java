import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int v : graph[i]) {
                reverse.get(v).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int parent : reverse.get(node)) {
                outdegree[parent]--;
                if (outdegree[parent] == 0) {
                    q.offer(parent);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
