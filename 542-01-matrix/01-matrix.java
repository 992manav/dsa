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

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        // ✅ Start BFS from all 0s (not 1s!)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.add(new Pair(i, j));
                } else {
                    res[i][j] = -1;  // unknown distance
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && res[nr][nc] == -1) {
                    res[nr][nc] = res[r][c] + 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return res;
    }
}
