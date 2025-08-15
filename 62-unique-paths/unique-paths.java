class Solution {

    int m, n;
    int[][] dp;

    int fun(int r, int c){
        if(r == m - 1 && c == n - 1) return 1;
        if(r >= m || c >= n) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        int down = fun(r + 1, c);
        int right = fun(r, c + 1);

        return dp[r][c] = down + right;
    }

    public int uniquePaths(int m, int n){
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
        return fun(0, 0);
    }
}
