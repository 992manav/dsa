class Solution {

    List<Integer>[] graph;
    int[] values;
    long total;

    long dfs(int node, int parent, long target, int[] count) {
        long sum = values[node];

        for (int child : graph[node]) {
            if (child == parent) continue;
            long childSum = dfs(child, node, target, count);
            sum += childSum;
        }

        if (sum == target) {
            count[0]++;
            return 0;
        }

        return sum;
    }

    public int componentValue(int[] nums, int[][] edges) {

        int n = nums.length;
        values = nums;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        total = 0;
        for (int x : nums) total += x;

        int result = 0;

        for (long target = 1; target <= total; target++) {
            if (total % target != 0) continue;

            int[] a = new int[1];
            dfs(0, -1, target, a);

            if (a[0] == total / target) {
                result = a[0] - 1;
                break;
            }
        }

        return result;
    }
}
