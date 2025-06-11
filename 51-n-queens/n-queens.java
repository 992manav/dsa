import java.util.*;

class Solution {

    List<List<String>> finalResult = new ArrayList<>();

    void fun(char[][] board, List<Integer> columns, int index, int column_index) {
        int x = index;

        if (index == board.length) {
            // ✅ All queens placed, convert board to list of strings
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(String.valueOf(row));
            }
            finalResult.add(temp);
            return;
        }

        if (columns.isEmpty() || column_index == columns.size()) {
            return;
        }

        int y = columns.get(column_index);
        if (check(board, x, y)) {
            board[x][y] = 'Q';
            columns.remove(column_index);

            fun(board, columns, index + 1, 0);

            board[x][y] = '.';
            columns.add(column_index, y);

             // ⬅️ No need to try further after successful placement
        }

        // Try next column choice
        fun(board, columns, index, column_index + 1);
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
        List<Integer> columns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
            columns.add(i);
        }

        fun(board, columns, 0, 0);

        return finalResult;
    }
}
