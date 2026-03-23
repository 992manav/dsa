class Solution {
    int n;
    int m;
    int[][] nums;
    long[][][] dp;
    boolean[][] vis;

    long[] fun(int i, int j) {
        if (i >= n || j >= m) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }

        if (vis[i][j]) {
            return dp[i][j];
        }

        if (i == n - 1 && j == m - 1) {
            return dp[i][j] = new long[]{nums[i][j], nums[i][j]};
        }

        long[] x = fun(i + 1, j);
        long[] y = fun(i, j + 1);

        long d1 = Long.MIN_VALUE, d2 = Long.MAX_VALUE;
        long r1 = Long.MIN_VALUE, r2 = Long.MAX_VALUE;

        long curr = nums[i][j];

        if (x[0] != Long.MIN_VALUE) {
            long a = curr * x[0];
            long b = curr * x[1];
            d1 = Math.max(a, b);
            d2 = Math.min(a, b);
        }

        if (y[0] != Long.MIN_VALUE) {
            long a = curr * y[0];
            long b = curr * y[1];
            r1 = Math.max(a, b);
            r2 = Math.min(a, b);
        }

        long maxVal = Math.max(d1, r1);
        long minVal = Math.min(d2, r2);

        if (maxVal == Long.MIN_VALUE) {
            return dp[i][j] = new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }

        vis[i][j] = true;
        return dp[i][j] = new long[]{maxVal, minVal};
    }

    public int maxProductPath(int[][] grid) {
        nums = grid;
        n = grid.length;
        m = grid[0].length;

        dp = new long[n][m][2];
        vis = new boolean[n][m];

        long[] res = fun(0, 0);
        long ans = res[0];

        if (ans < 0) {
            return -1;
        }

        return (int)(ans % 1000000007);
    }
}