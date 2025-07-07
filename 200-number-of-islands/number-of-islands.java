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
        grid[row][col] = '0'; 

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = p.row + dx[i];
                int newCol = p.col + dy[i];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0'; 
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, q, i, j);
                }
            }
        }

        return count;
    }
}
