import java.util.*;

class Solution {

    char[][] board;
    int rows, cols;

    void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j] = '#';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                bfs(0, j);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[rows - 1][j] == 'O') {
                bfs(rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                bfs(i, cols - 1);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
