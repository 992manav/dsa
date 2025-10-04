class Solution {

    int m, n;
    int[][] grid;
    int[][] dp;

    int fun(int i, int j) {

        // Out of bounds
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        // Destination reached
        if (i == m - 1 && j == n - 1) return grid[i][j];

        // Check memo
        if (dp[i][j] != -1) return dp[i][j];

        // Explore down and right
        int down = fun(i + 1, j);
        int right = fun(i, j + 1);

        dp[i][j] = grid[i][j] + Math.min(down, right); // combine addition here

        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        return fun(0, 0);
    }
}
