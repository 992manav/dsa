class Solution {
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {

                    boolean left = j > 0 && board[i][j - 1] == 'X';
                    boolean right = j < n - 1 && board[i][j + 1] == 'X';
                    boolean up = i > 0 && board[i - 1][j] == 'X';
                    boolean down = i < m - 1 && board[i + 1][j] == 'X';

                    // horizontal ship ending here
                    if (left && !right) {
                        count++;
                    }
                    // vertical ship ending here
                    else if (up && !down) {
                        count++;
                    }
                    // single cell ship
                    else if (!left && !right && !up && !down) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
