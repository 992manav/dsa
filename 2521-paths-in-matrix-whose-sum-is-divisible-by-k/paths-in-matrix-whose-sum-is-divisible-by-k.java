class Solution {
    int m, n, k;
    int[][] grid;
    Integer[][][] dp;
    final int mod = 1000000007;

    int fun(int i, int j, int sum) {
        if (i >= m || j >= n) return 0;

        if (i == m - 1 && j == n - 1) {
            sum = (sum + grid[i][j]) % k;
            if (sum == 0) return 1;
            return 0;
        }

        if (dp[i][j][sum] != null) return dp[i][j][sum];

        int newSum = (sum + grid[i][j]) % k;

        long down = fun(i + 1, j, newSum);
        long right = fun(i, j + 1, newSum);

        long ans = (down + right) % mod;

        dp[i][j][sum] = (int) ans;
        return dp[i][j][sum];
    }

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][k];
        return fun(0, 0, 0);
    }
}
