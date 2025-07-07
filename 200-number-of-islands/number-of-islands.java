class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    void bfs(char[][] grid, Queue<Pair> q, int row, int col) {
        q.offer(new Pair(row, col));
        grid[row][col] = '0'; // mark as visited

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            // up
            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                grid[r - 1][c] = '0';
                q.offer(new Pair(r - 1, c));
            }

            // down
            if (r + 1 < n && grid[r + 1][c] == '1') {
                grid[r + 1][c] = '0';
                q.offer(new Pair(r + 1, c));
            }

            // left
            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                grid[r][c - 1] = '0';
                q.offer(new Pair(r, c - 1));
            }

            // right
            if (c + 1 < m && grid[r][c + 1] == '1') {
                grid[r][c + 1] = '0';
                q.offer(new Pair(r, c + 1));
            }
        }
    }

    public int numIslands(char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, q, i, j);
                }
            }
        }

        return count;
    }
}
