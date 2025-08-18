import java.util.PriorityQueue;
import java.util.Arrays;

class Node implements Comparable<Node> {
    int i;
    int j;
    int dist;

    Node(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist - other.dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] maxVal = new int[n][m];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0, 0));
        for (int i = 0; i < maxVal.length; i++) {
            Arrays.fill(maxVal[i], Integer.MAX_VALUE);
        }
        maxVal[0][0] = 0;

        while (!pq.isEmpty()) {

            Node nd = pq.poll();

            int r = nd.i;
            int c = nd.j;

            if(!visited[r][c]){

                visited[r][c] = true;

                int[] dirx = new int[]{-1, 1, 0, 0};
                int[] diry = new int[]{0, 0, 1, -1};
                
                for (int i = 0; i < dirx.length; i++) {
                    int newR = r + dirx[i];
                    int newC = c + diry[i];

                    if (newR < 0 || newR >= n || newC < 0 || newC >= m) continue;

                    int v = Math.abs(grid[newR][newC] - grid[r][c]);

                    if(v > maxVal[r][c]){
                        if(maxVal[newR][newC] > v){
                            maxVal[newR][newC] = v;
                            pq.add(new Node(newR, newC, maxVal[newR][newC]));
                        }
                    } else {
                        if(maxVal[newR][newC] > maxVal[r][c]){
                            maxVal[newR][newC] = maxVal[r][c];
                            pq.add(new Node(newR, newC, maxVal[newR][newC]));
                        }
                    }

                }
            }

        }

        return maxVal[n - 1][m - 1];
    }
}
