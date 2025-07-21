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

    List<List<Pair>> final_lst = new ArrayList<>();
    char[][] board;
    int rows, cols;

    void bfs(int i, int j) {
        board[i][j] = 'X';
        Queue<Pair> q = new LinkedList<>();
        List<Pair> lst = new ArrayList<>();
        Pair start = new Pair(i, j);
        q.add(start);
        lst.add(start);

        boolean flag = false;

        int[] dir = {1, -1, 0, 0};
        int[] dic = {0, 0, 1, -1};
        int dLen = dir.length;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;

            if (!flag && isEdge(r, c)) {
                flag = true;
            }

            for (int k = 0; k < dLen; k++) {
                int nr = r + dir[k];
                int nc = c + dic[k];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && board[nr][nc] == 'O') {
                    board[nr][nc] = 'X';
                    Pair next = new Pair(nr, nc);
                    lst.add(next);
                    q.add(next);
                }
            }
        }

        if (flag) {
            final_lst.add(lst);
        }
    }

    boolean isEdge(int i, int j) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    bfs(i, j);
                }
            }
        }

        for (List<Pair> list : final_lst) {
            for (Pair p : list) {
                board[p.row][p.col] = 'O';
            }
        }
    }
}
