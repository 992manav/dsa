import java.util.*;

class Solution {

    List<int[]> final_lst = new ArrayList<>();
    char[][] board;
    int rows, cols;

    void bfs(int i, int j) {
        board[i][j] = 'X';
        Deque<int[]> q = new ArrayDeque<>();
        List<int[]> lst = new ArrayList<>();
        q.add(new int[]{i, j});
        lst.add(new int[]{i, j});

        boolean flag = false;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] p = q.remove();
            int r = p[0], c = p[1];

            if (!flag && isEdge(r, c)) {
                flag = true;
            }

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && board[nr][nc] == 'O') {
                    board[nr][nc] = 'X';
                    int[] next = new int[]{nr, nc};
                    lst.add(next);
                    q.add(next);
                }
            }
        }

        if (flag) {
            final_lst.addAll(lst);
        }
    }

    boolean isEdge(int i, int j) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }

    public void solve(char[][] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    bfs(i, j);
                }
            }
        }

        for (int[] p : final_lst) {
            board[p[0]][p[1]] = 'O';
        }
    }
}
