class Solution {
    int n;
    int m;
    int[][] dp;
    int[][] prod;

    int fun(int i, int j) {

        if (i >= n || j >= m) {
            return Integer.MIN_VALUE ;
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int next = fun(i + 1, j + 1);
        int take;
        if (next < 0) {
            take = prod[i][j];
        } else {
            take = next + prod[i][j];
        }

        int skip_row = fun(i + 1, j);
        int skip_col = fun(i, j + 1);

        dp[i][j] = Math.max(take, Math.max(skip_row, skip_col));
        return dp[i][j];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;

        dp = new int[n][m];
        prod = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prod[i][j] = nums1[i] * nums2[j];
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return fun(0, 0);
    }
}
