class Solution {

    int end;
    int offset = 1000;
    int MOD = 1000000007;
    long[][] dp;

    long fun(int pos, int k) {

        if (k == 0) {
            if (pos == end) {
                return 1;
            }
            return 0;
        }

        if (dp[pos + offset][k] != -1) {
            return dp[pos + offset][k];
        }

        long a = fun(pos + 1, k - 1);
        long b = fun(pos - 1, k - 1);

        dp[pos + offset][k] = (a + b) % MOD;
        return dp[pos + offset][k];
    }

    public int numberOfWays(int startPos, int endPos, int k) {

        end = endPos;
        dp = new long[3001][k + 1];

        for (int i = 0; i < 3001; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }

        return (int)(fun(startPos, k) % MOD);
    }
}
