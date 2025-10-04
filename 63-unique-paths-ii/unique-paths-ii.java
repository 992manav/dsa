class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start is blocked, no path
        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = (obstacleGrid[m-1][n-1] == 0) ? 1 : 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // Blocked cell
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // Destination already initialized
                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                // Explore down and right
                int down = (i + 1 < m) ? dp[i + 1][j] : 0;
                int right = (j + 1 < n) ? dp[i][j + 1] : 0;

                dp[i][j] = down + right;
            }
        }

        return dp[0][0];
    }
}
