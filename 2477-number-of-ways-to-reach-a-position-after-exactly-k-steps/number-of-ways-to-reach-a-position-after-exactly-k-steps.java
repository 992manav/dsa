class Solution {
    int endPos;
    long[][] dp;
    int offset = 1000;
    final int MOD = 1000000007;

    long fun(int i, int k) {
        if (k == 0) {
            if (i == endPos) return 1;
            return 0;
        }
        if (dp[i + offset][k] != -1) return dp[i + offset][k];
        long front = fun(i + 1, k - 1);
        long back = fun(i - 1, k - 1);
        dp[i + offset][k] = (front + back) % MOD;
        return dp[i + offset][k];
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        this.endPos = endPos;
        dp = new long[3001][k + 1];
        for (int i = 0; i < 3001; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return (int)(fun(startPos, k) % MOD);
    }
}
