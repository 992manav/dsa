class Solution {
    public int[] findOrder(int n, int[][] edge) {
        
        int[] indegree = new int[n];
        Arrays.fill(indegree, 0); 

        List<Integer>[] graph = new ArrayList[n]; 
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][1];
            int to = edge[i][0];

            indegree[to]++;
            graph[from].add(to);
        }

        Queue<Integer> q = new LinkedList<>(); 

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            result.add(node);
            List<Integer> neighbours = graph[node];
            for (int i = 0; i < neighbours.size(); i++) { 
                int neighbour = neighbours.get(i); 

                indegree[neighbour]--; 

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if (result.size() < n) {
            return new int[0]; 
        } else {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = result.get(i); 
            }
            return res;
        }
    }
}
