import java.util.*;

class Solution {

    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        grid[0][0] = 1;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0}, {1, 1}
        };

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int dist = grid[r][c];

            if (r == n - 1 && c == n - 1) return dist;

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = dist + 1; // mark visited and store distance
                }
            }
        }

        return -1; // no path found
    }
}
