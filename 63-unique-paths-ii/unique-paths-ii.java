class Solution {

    int m, n;
    int[][] grid;
    int[][] dp;

    int fun(int i, int j) {

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Blocked cell
        if (grid[i][j] == 1) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Check memo
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Explore down and right
        int down = fun(i + 1, j);
        int right = fun(i, j + 1);

        return dp[i][j] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.m = grid.length;
        this.n = grid[0].length;

        // If start is blocked, no path
        if (grid[0][0] == 1) return 0;

        // Initialize dp array with -1
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0);
    }
}
