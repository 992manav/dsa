class Solution {
    int n;
    int[] nums;
    int[] prefix;
    int[][][] dp;

    int fun(int i, int start, int k) {
        if (i == n) {
            if (k != 0) return Integer.MAX_VALUE;
            int curXor = prefix[n - 1] ^ (start > 0 ? prefix[start - 1] : 0);
            return curXor;
        }

        if (dp[i][start][k] != -1) {
            return dp[i][start][k];
        }

        int ans = Integer.MAX_VALUE;

        // continue segment
        ans = Math.min(ans, fun(i + 1, start, k));

        // cut here
        if (k > 0) {
            int curXor = prefix[i - 1] ^ (start > 0 ? prefix[start - 1] : 0);
            int next = fun(i + 1, i, k - 1);
            ans = Math.min(ans, Math.max(curXor, next));
        }

        return dp[i][start][k] = ans;
    }

    public int minXor(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;

        prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }

        dp = new int[n + 1][n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        return fun(1, 0, k - 1);
    }
}
