class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int m, n;
        int[][] mat;
        int[][] dp;

        m = matrix.length;
        n = matrix[0].length;
        mat = matrix;
        dp = new int[m][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i >= m || j < 0 || j >= n) {
                    return Integer.MAX_VALUE;
                }

                if (i == n - 1) {
                    dp[i][j] = mat[i][j];
                    continue;
                }

                // ✅ Added safety checks before accessing neighbors
                int left_diag = (i + 1 < m && j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int down = (i + 1 < m) ? dp[i + 1][j] : Integer.MAX_VALUE;
                int right_diag = (i + 1 < m && j + 1 < n) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                int min_sum = Math.min(left_diag, Math.min(down, right_diag));

                dp[i][j] = min_sum + mat[i][j];
            }
        }

        int min_sum = Integer.MAX_VALUE;
        for (int j = 0; j < mat[0].length; j++) {
            min_sum = Math.min(min_sum, dp[0][j]);
        }

        return min_sum;
    }
}
