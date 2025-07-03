class Solution {

    int[] dp;

    int fun(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fun(n - 1) + fun(n - 2);
        return dp[n];
    }

    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fun(n);
    }
}
