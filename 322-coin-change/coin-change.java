import java.util.Arrays;

class Solution {

    int[][] dp;

    int fun(int[] coins, int index, int amount, int count) {

        if (amount == 0) {
            return 0;
        }

        if (index < 0) {
            return -1;
        }

        if (dp[index][amount] != -2) {
            if (dp[index][amount] == -1) {
                return -1;
            }
            return dp[index][amount];
        }

        int best = Integer.MAX_VALUE;

        if (amount < coins[index]) {
            int res = fun(coins, index - 1, amount, count);
            if (res != -1) {
                best = res;
            }
        } else {
            int maxUse = amount / coins[index];
            for (int used = maxUse; used >= 0; used--) {
                int newAmount = amount - used * coins[index];
                int res = fun(coins, index - 1, newAmount, count + used);
                if (res != -1) {
                    if (res + used < best) {
                        best = res + used;
                    }
                }
            }
        }

        if (best == Integer.MAX_VALUE) {
            dp[index][amount] = -1;
            return -1;
        }

        dp[index][amount] = best;
        return best;
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        Arrays.sort(coins);

        dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -2);
        }

        return fun(coins, n - 1, amount, 0);
    }
}
