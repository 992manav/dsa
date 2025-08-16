import java.util.*;

class Edges implements Comparable<Edges> {
    int src;
    int dest;
    int dist;

    Edges(int src, int dest, int dist) {
        this.src = src;
        this.dest = dest;
        this.dist = dist;
    }

    public int compareTo(Edges other) {
        return this.dist - other.dist; // dist upar base kari compare karva mate (priority queue ma min dist pela aave)
    }
}

class Solution {

    int[] parent;
    int[] rank;

    public int find_parent(int node) {
        if (parent[node] == node) {
            return node; // jyare node potano parent hoy, return thai jaay
        }
        return parent[node] = find_parent(parent[node]); // path compression: sidha root sathe connect kari de
    }

    public void union(int a, int b) {
        int p1 = find_parent(a);
        int p2 = find_parent(b);

        if (p1 == p2) {
            return; // already same parent hoy to union ni jarur nathi
        }

        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 > r2) {
            parent[p2] = p1; // mota rank walo parent bani jaay
        } else if (r1 < r2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1; 
            rank[p1]++; // banne same rank hoy to koi ek nu rank vadhaadviye
        }
    }

    public int minimumEffortPath(int[][] heights) {
        // Method 1 Kruskal algo
        PriorityQueue<Edges> pq = new PriorityQueue<>();
        // store all edges
        int n = heights.length;
        int m = heights[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m) {
                    pq.offer(new Edges(i * m + j, i * m + (j + 1), Math.abs(heights[i][j] - heights[i][j + 1]))); // right neighbor sathe edge
                }
                if (i + 1 < n) {
                    pq.offer(new Edges(i * m + j, (i + 1) * m + j, Math.abs(heights[i][j] - heights[i + 1][j]))); // down neighbor sathe edge
                }
            }
        }

        parent = new int[n * m];
        rank = new int[n * m];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // pratyek node nu parent potane banaviye
            rank[i] = 0;
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Edges e = pq.poll(); // smallest dist edge pelo nikdi jaay (pq maathi)

            int s = e.src;
            int d = e.dest;
            int dist = e.dist;

            union(s, d); // aa edge add kariye

            if (find_parent(0) == find_parent(n * m - 1)) { 
                ans = dist; // pela vakhat 0 thi end connect thay -> aa dist e paath ma max edge hoy, etle aa min effort hoy
                break;
            }
        }

        return ans;
    }
}
