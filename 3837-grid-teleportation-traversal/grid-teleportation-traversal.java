import java.util.*;

class Solution {

    static class Pair {
        int i;
        int j;
        int cost;

        Pair(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    int m;
    int n;

    int[] dirx = {-1, 1, 0, 0};
    int[] diry = {0, 0, -1, 1};

    boolean[] usedPortal = new boolean[26];

    void sabkoadd(
        int curr_i,
        int curr_j,
        int cost,
        char c,
        boolean[][] visited,
        char[][] matrix,
        Queue<Pair> q
    ) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (
                    !(i == curr_i && j == curr_j) &&
                    !visited[i][j] &&
                    matrix[i][j] == c
                ) {
                    q.offer(new Pair(i, j, cost));
                }
            }
        }
    }

    int fun(int si, int sj, char[][] matrix) {

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(si, sj, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int cost = p.cost;

            if (i == m - 1 && j == n - 1) {
                return cost;
            }

            if (visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            if (matrix[i][j] >= 'A' && matrix[i][j] <= 'Z') {
                int idx = matrix[i][j] - 'A';
                if (!usedPortal[idx]) {
                    usedPortal[idx] = true;
                    sabkoadd(i, j, cost, matrix[i][j], visited, matrix, q);
                }
            }

            for (int d = 0; d < 4; d++) {
                int ni = i + dirx[d];
                int nj = j + diry[d];

                if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                    continue;
                }

                if (visited[ni][nj]) {
                    continue;
                }

                if (matrix[ni][nj] == '.') {
                    q.offer(new Pair(ni, nj, cost + 1));
                } else if (matrix[ni][nj] == '#') {
                    continue;
                } else {
                    q.offer(new Pair(ni, nj, cost + 1));

                    int idx = matrix[ni][nj] - 'A';
                    if (!usedPortal[idx]) {
                        usedPortal[idx] = true;
                        sabkoadd(ni, nj, cost + 1, matrix[ni][nj], visited, matrix, q);
                    }
                }
            }
        }

        return -1;
    }

    public int minMoves(String[] grid) {

        m = grid.length;
        n = grid[0].length();

        char[][] matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i] = grid[i].toCharArray();
        }

        if (matrix[0][0] == '#' || matrix[m - 1][n - 1] == '#') {
            return -1;
        }

        return fun(0, 0, matrix);
    }
}
