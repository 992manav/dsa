class Solution {
    int n;
    int[] nums;
    int[] prefix;
    int[][][] dp;

    int getXor(int l, int r) {
        if (l > r) return 0;
        if (l == 0) return prefix[r];
        return prefix[r] ^ prefix[l - 1];
    }

    int fun(int i, int start, int k) {
        if (i == n) {
            if (k != 0) return Integer.MAX_VALUE;
            return getXor(start, n - 1);
        }

        if (dp[i][start][k] != -1) {
            return dp[i][start][k];
        }

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, fun(i + 1, start, k));
       
        if (k > 0) {
            int curXor = getXor(start, i - 1);
            int next = fun(i + 1, i, k - 1);
            ans = Math.min(ans, Math.max(curXor, next));
        }

        dp[i][start][k] = ans;
        return ans;
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
