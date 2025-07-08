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

    int newValue;

    void bfs(int[][] grid, Queue<Pair> q, int oldValue) {
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            Pair p = q.remove();

            int r = p.row;
            int c = p.col;

            // up
            if (r - 1 >= 0 && grid[r - 1][c] == oldValue) {
                grid[r - 1][c] = newValue;
                q.offer(new Pair(r - 1, c));
            }

            // down
            if (r + 1 < n && grid[r + 1][c] == oldValue) {
                grid[r + 1][c] = newValue;
                q.offer(new Pair(r + 1, c));
            }

            // left
            if (c - 1 >= 0 && grid[r][c - 1] == oldValue) {
                grid[r][c - 1] = newValue;
                q.offer(new Pair(r, c - 1));
            }

            // right
            if (c + 1 < m && grid[r][c + 1] == oldValue) {
                grid[r][c + 1] = newValue;
                q.offer(new Pair(r, c + 1));
            }
        }
    }

    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int oldValue = grid[sr][sc];
        if (oldValue == color) return grid; // avoid infinite loop

        newValue = color;
        Queue<Pair> q = new LinkedList<>();
        grid[sr][sc] = newValue; // color the starting cell
        q.add(new Pair(sr, sc));
        bfs(grid, q, oldValue);

        return grid;
    }
}
