import java.util.*;

class Solution {

    List<List<String>> finalResult = new ArrayList<>();

    void fun(List<StringBuilder> board, List<Integer> columns, int index, int column_index) {
        int x = index;

        if (index == board.size()) {
            // ✅ All queens placed, convert board to List<String>
            List<String> temp = new ArrayList<>();
            for (StringBuilder row : board) {
                temp.add(row.toString());
            }
            finalResult.add(temp);
            return;
        }

        if (columns.isEmpty() || column_index == columns.size()) {
            return;
        }

        int y = columns.get(column_index);
        if (check(board, x, y)) {
            board.get(x).setCharAt(y, 'Q');
            columns.remove(column_index);

            fun(board, columns, index + 1, 0);

            board.get(x).setCharAt(y, '.');
            columns.add(column_index, y);
        }

        // Try next column choice
        fun(board, columns, index, column_index + 1);
    }

    boolean check(List<StringBuilder> board, int row, int col) {
        int n = board.size();

        // Check column
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row);
            columns.add(i);
        }

        fun(board, columns, 0, 0);
        return finalResult;
    }
}
