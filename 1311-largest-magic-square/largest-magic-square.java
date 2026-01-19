class Solution {
    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix_row = new int[m][n + 1];
        int[][] prefix_col = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix_row[i][j + 1] = prefix_row[i][j] + grid[i][j];
                prefix_col[i + 1][j] = prefix_col[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        int ans = 1;

        for (int size = 2; size <= Math.min(m, n); size++) {

            boolean found = false;

            for (int i = 0; i + size <= m && !found; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = prefix_row[i][j + size] - prefix_row[i][j];
                    boolean ok = true;

                    for (int r = i; r < i + size; r++) {
                        if (prefix_row[r][j + size] - prefix_row[r][j] != target) {
                            ok = false;
                            break;
                        }
                    }

                    for (int c = j; c < j + size && ok; c++) {
                        if (prefix_col[i + size][c] - prefix_col[i][c] != target) {
                            ok = false;
                            break;
                        }
                    }

                    int d1 = diag1[i + size][j + size] - diag1[i][j];
                    int d2 = diag2[i + size][j] - diag2[i][j + size];

                    if (ok && d1 == target && d2 == target) {
                        ans = size;
                        found = true;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
