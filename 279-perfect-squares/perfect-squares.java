class Solution {

    int[] dp = new int[10001];

    int fun(int n) {
        if (n == 0) return 0;
        if (n < 0) return -1;

        if (dp[n] != 0) return dp[n];

        int root = (int) Math.sqrt(n);
        int best = Integer.MAX_VALUE;

        for (int i = root; i >= 1; i--) {
            int r = fun(n - i * i);
            if (r != -1) {
                int val = r + 1;
                if (val < best) best = val;
            }
        }

        if (best == Integer.MAX_VALUE) {
            dp[n] = -1;
            return -1;
        }

        dp[n] = best;
        return best;
    }

    public int numSquares(int n) {
        return fun(n);
    }
}
