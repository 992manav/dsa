class Solution {
    int[][] dp;
    int[] a, b;

    int fun(int i, int j) {

        if (i == a.length || j == b.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a[i] == b[j]) {
            dp[i][j] = 1 + fun(i + 1, j + 1);
            return dp[i][j];
        }

        int op1 = fun(i + 1, j);
        int op2 = fun(i, j + 1);

        if (op1 > op2) {
            dp[i][j] = op1;
        } else {
            dp[i][j] = op2;
        }

        return dp[i][j];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        a = nums1;
        b = nums2;

        dp = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0);
    }
}
