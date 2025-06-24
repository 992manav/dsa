import java.util.*;

class Solution {

    boolean checkRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char val = board[row][i];
            if (val != '.' && !set.add(val)) {
                return false;
            }
        }
        return true;
    }

    boolean checkColumn(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char val = board[i][col];
            if (val != '.' && !set.add(val)) {
                return false;
            }
        }
        return true;
    }

    boolean checkBlock(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char val = board[i][j];
                if (val != '.' && !set.add(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i) || !checkColumn(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBlock(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
