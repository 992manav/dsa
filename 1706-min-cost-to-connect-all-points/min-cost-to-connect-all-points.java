import java.util.*;

class Edge implements Comparable<Edge> {
    int i;
    int j;
    int dist;

    Edge(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }

    public int compareTo(Edge other) {
        return this.dist - other.dist;
    }
}

class Solution {
    int[] parent;
    int[] rank;

    public int findParent(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = findParent(parent[i]);
    }

    public void unionByRank(int p1, int p2) {
        int r1 = rank[p1];
        int r2 = rank[p2];

        if (r1 < r2) {
            parent[p1] = p2;
        } else if (r1 > r2) {
            parent[p2] = p1;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new Edge(i, j, dist));
            }
        }

        int cost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n - 1) {
            Edge e = pq.remove();
            int i = e.i;
            int j = e.j;
            int dist = e.dist;

            int parent1 = findParent(i);
            int parent2 = findParent(j);

            if (parent1 != parent2) {
                unionByRank(parent1, parent2);
                cost += dist;
                edgesUsed++;
            }
        }

        return cost;
    }
}
