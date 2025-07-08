import java.util.*;

class Solution {

    HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
    int[] parent;
    int[] rank;

    int find_parent(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find_parent(parent[n]); // path compression
    }

    void union(int a, int b) {
        int parent_a = find_parent(a);
        int parent_b = find_parent(b);

        if (parent_a == parent_b) {
            return;
        }

        int rank_a = rank[parent_a];
        int rank_b = rank[parent_b];

        if (rank_a < rank_b) {
            parent[parent_a] = parent_b;
        } else if (rank_b < rank_a) {
            parent[parent_b] = parent_a;
        } else {
            parent[parent_a] = parent_b;
            rank[parent_b]++;
        }
    }

    public int[] processQueries(int c, int[][] edge, int[][] queries) {
        parent = new int[c];
        rank = new int[c];
        Arrays.fill(rank, 0);

        for (int i = 0; i < c; i++) {
            parent[i] = i;
        }

        // Convert 1-based to 0-based edges
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            union(a, b);
        }

        // Build component map using updated parents
        for (int i = 0; i < c; i++) {
            int p = find_parent(i);
            map.putIfAbsent(p, new TreeSet<>());
            map.get(p).add(i);
        }

        boolean[] offline = new boolean[c];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int check = queries[i][0];
            int val = queries[i][1] - 1; // 1-based to 0-based
            int p = find_parent(val);

            if (check == 2) {
                offline[val] = true;
                TreeSet<Integer> set = map.get(p);
                if (set != null) set.remove(val);
            } else {
                if (offline[val]) {
                    TreeSet<Integer> set = map.get(p);
                    if (set != null && !set.isEmpty()) {
                        result.add(set.first() + 1); // back to 1-based
                    } else {
                        result.add(-1);
                    }
                } else {
                    result.add(val + 1); // back to 1-based
                }
            }
        }

        // Convert result to int[]
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}
