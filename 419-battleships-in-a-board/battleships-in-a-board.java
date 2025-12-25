class Solution {
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {

                    if (j > 0 && board[i][j - 1] == 'X') {

                        if (j < n - 1 && board[i][j + 1] == 'X') {
                            continue;
                        } else {
                            count++;
                        }

                    } else if (j < n - 1 && board[i][j + 1] == 'X') {

                        continue;

                    } else {

                        if (i > 0 && board[i - 1][j] == 'X') {

                            if (i < m - 1 && board[i + 1][j] == 'X') {
                                continue;
                            } else {
                                count++;
                            }

                        } else if (i < m - 1 && board[i + 1][j] == 'X') {

                            continue;

                        } else {

                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
