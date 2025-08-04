import java.util.*;

class Pair implements Comparable<Pair> {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }

    public int compareTo(Pair other) {
        return this.time - other.time;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] edges, int fp) {
        List<Integer> lst = new ArrayList<>();
        ArrayList<Pair>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int time = edges[i][2];

            graph[from].add(new Pair(to, time));
            graph[to].add(new Pair(from, time));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        pq.add(new Pair(fp, 0));

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int node = p.node;
            int t = p.time;

            if (visited[node]) continue;

            visited[node] = true;
            lst.add(node);

            List<Pair> neighbour = graph[node];

            for (int i = 0; i < neighbour.size(); i++) {
                Pair nei = neighbour.get(i);

                if (!visited[nei.node] && nei.time >= t) {
                    pq.add(new Pair(nei.node, nei.time));
                }
            }
        }

        return lst;
    }
}
