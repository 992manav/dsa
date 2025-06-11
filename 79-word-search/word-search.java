class Solution {

    char[][] board;
    String word;
    boolean[][] visited;

    boolean fun(int x, int y, int k) {
        if (k == word.length()) return true;

        visited[x][y] = true;

        if (x + 1 < board.length && !visited[x + 1][y] && board[x + 1][y] == word.charAt(k)) {
            if (fun(x + 1, y, k + 1)) return true;
        }
        if (y + 1 < board[0].length && !visited[x][y + 1] && board[x][y + 1] == word.charAt(k)) {
            if (fun(x, y + 1, k + 1)) return true;
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == word.charAt(k)) {
            if (fun(x - 1, y, k + 1)) return true;
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == word.charAt(k)) {
            if (fun(x, y - 1, k + 1)) return true;
        }

        visited[x][y] = false; // backtrack
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (fun(i, j, 1)) return true;
                }
            }
        }
        return false;
    }
}
