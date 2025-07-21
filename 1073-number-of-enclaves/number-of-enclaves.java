import java.util.*;

class Solution {
    int[][] board;
    int rows, cols;

    void multisourceBFS(List<int[]> sources) {
        Queue<int[]> q = new LinkedList<>(sources);

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

        List<int[]> sources = new ArrayList<>();

        // Collect all boundary land cells (sources)
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 1) {
                board[0][j] = 0;
                sources.add(new int[]{0, j});
            }
            if (board[rows - 1][j] == 1) {
                board[rows - 1][j] = 0;
                sources.add(new int[]{rows - 1, j});
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 1) {
                board[i][0] = 0;
                sources.add(new int[]{i, 0});
            }
            if (board[i][cols - 1] == 1) {
                board[i][cols - 1] = 0;
                sources.add(new int[]{i, cols - 1});
            }
        }

        // Perform multisource flood fill
        multisourceBFS(sources);

        // Count remaining land
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
