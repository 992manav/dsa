class Solution {
    static final int MOD = 1_000_000_007;
    int n;
    Integer[][] dp;

    int fun(int index, int[] arr, int sum) {
        if (sum > n) return 0;
        if (index == -1) {
            return sum == n ? 1 : 0;
        }
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        int ways;
        if (sum + arr[index] > n) {
            ways = fun(index - 1, arr, sum);
        } else {
            ways = (fun(index - 1, arr, sum + arr[index]) + fun(index - 1, arr, sum)) % MOD;
        }

        dp[index][sum] = ways;
        return ways;
    }

    public int numberOfWays(int n, int x) {
        this.n = n;
        int high = (int) Math.pow(n, 1.0 / x);
        int[] arr = new int[high + 1];
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.pow(num, x);
            num++;
        }
        dp = new Integer[high + 1][n + 1];
        return fun(high, arr, 0);
    }
}
