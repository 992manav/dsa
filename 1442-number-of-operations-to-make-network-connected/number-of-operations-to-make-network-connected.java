class Solution {
    int[] parent;
    int[] rank;

    public int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int p1, int p2) {
        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 > r2) {
            parent[p2] = p1;
        } else if (r1 < r2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
    }

    public int makeConnected(int n, int[][] con) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int count = 0; // number of connections used
        for (int i = 0; i < con.length; i++) {
            int a = con[i][0];
            int b = con[i][1];
            int p1 = findParent(a);
            int p2 = findParent(b);

            if (p1 != p2) {
                count++;
                unionByRank(p1, p2);
            }
        }

        int count2 = 0; // number of components
        for (int i = 0; i < n; i++) {
            if (findParent(i) == i) {
                count2++;
            }
        }

        int reuse = con.length - count;

        if (reuse >= count2 - 1) {
            return count2 - 1;
        } else {
            return -1;
        }
    }
}
