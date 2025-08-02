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
    int[][] grid;
    int rows, cols;

    public int bfs(int i, int j) {
        int area = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        grid[i][j] = 0; // Mark as visited

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
            area++;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = 0; // Mark visited
                }
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] inputGrid) {
        grid = inputGrid;
        rows = grid.length;
        cols = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        return maxArea;
    }
}
