class Solution {

    int newValue;
    int oldValue;
    int n, m;

    void dfs(int[][] grid, int r, int c) {
        // Up
        if (r - 1 >= 0 && grid[r - 1][c] == oldValue) {
            grid[r - 1][c] = newValue;
            dfs(grid, r - 1, c);
        }

        // Down
        if (r + 1 < n && grid[r + 1][c] == oldValue) {
            grid[r + 1][c] = newValue;
            dfs(grid, r + 1, c);
        }

        // Left
        if (c - 1 >= 0 && grid[r][c - 1] == oldValue) {
            grid[r][c - 1] = newValue;
            dfs(grid, r, c - 1);
        }

        // Right
        if (c + 1 < m && grid[r][c + 1] == oldValue) {
            grid[r][c + 1] = newValue;
            dfs(grid, r, c + 1);
        }
    }

    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        oldValue = grid[sr][sc];
        if (oldValue == color) return grid;

        newValue = color;
        n = grid.length;
        m = grid[0].length;

        grid[sr][sc] = newValue;
        dfs(grid, sr, sc);

        return grid;
    }
}
