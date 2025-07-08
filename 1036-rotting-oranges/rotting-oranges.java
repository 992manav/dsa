import java.util.*;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int bfs(int[][] grid, Queue<Pair> q) {
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                Pair p = q.remove();

                int r = p.row;
                int c = p.col;

                // up
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    q.offer(new Pair(r - 1, c));
                    rottedThisMinute = true;
                }

                // down
                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    q.offer(new Pair(r + 1, c));
                    rottedThisMinute = true;
                }

                // left
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    q.offer(new Pair(r, c - 1));
                    rottedThisMinute = true;
                }

                // right
                if (c + 1 < m && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    q.offer(new Pair(r, c + 1));
                    rottedThisMinute = true;
                }
            }

            if (rottedThisMinute)
                time++;
        }

        return time;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges to queue initially
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = bfs(grid, q);

        // Check if any fresh oranges left
        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}
