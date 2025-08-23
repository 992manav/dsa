class Solution {
    int n;
    int m;
    int[][] dp;

    int fun(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = fun(i + 1, j);
        int right = fun(i, j + 1);

        return dp[i][j] = down + right;
    }

    public int uniquePaths(int m, int n) {
        this.n = m;
        this.m = n;

        dp = new int[m][n];   
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0);
    }
}
