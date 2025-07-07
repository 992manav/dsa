class Solution {

    void bfs(char[][] grid, Queue<Integer> q, int row, int col, int cols) {
        q.offer(row * cols + col);
        grid[row][col] = '0'; // mark as visited

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int code = q.poll();
            int r = code / cols;
            int c = code % cols;

            // up
            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                grid[r - 1][c] = '0';
                q.offer((r - 1) * cols + c);
            }

            // down
            if (r + 1 < n && grid[r + 1][c] == '1') {
                grid[r + 1][c] = '0';
                q.offer((r + 1) * cols + c);
            }

            // left
            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                grid[r][c - 1] = '0';
                q.offer(r * cols + (c - 1));
            }

            // right
            if (c + 1 < m && grid[r][c + 1] == '1') {
                grid[r][c + 1] = '0';
                q.offer(r * cols + (c + 1));
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, q, i, j, m);
                }
            }
        }

        return count;
    }
}
