import java.util.*;

class Solution {
    int[][] board;
    int rows, cols;

    void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j] = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && board[nr][nc] == 1) {
                    board[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        this.board = grid;
        rows = board.length;
        cols = board[0].length;

        // Remove all land connected to boundary
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 1) bfs(0, j);
            if (board[rows - 1][j] == 1) bfs(rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 1) bfs(i, 0);
            if (board[i][cols - 1] == 1) bfs(i, cols - 1);
        }

        // Count remaining land cells
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
