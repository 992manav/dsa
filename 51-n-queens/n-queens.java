import java.util.*;

class Solution {

    List<List<String>> finalResult = new ArrayList<>();

    void fun(char[][] board, boolean[] usedColumns, int index, int column_index) {
        int x = index;

        if (index == board.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            finalResult.add(temp);
            return;
        }

        if (column_index == board.length) {
            return;
        }

        int y = column_index;
        if (!usedColumns[y] && check(board, x, y)) {
            board[x][y] = 'Q';
            usedColumns[y] = true;

            fun(board, usedColumns, index + 1, 0);

            board[x][y] = '.';
            usedColumns[y] = false;
        }

        // Try next column choice
        fun(board, usedColumns, index, column_index + 1);
    }

    boolean check(char[][] board, int row, int col) {
        int n = board.length;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        boolean[] usedColumns = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        fun(board, usedColumns, 0, 0);

        return finalResult;
    }
}
