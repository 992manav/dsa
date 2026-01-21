import java.util.*;

class Solution {

    int[][] dp;
    int[] coins;

    int fun(int index, int amt) {

        if (amt == 0) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }

        if (dp[index][amt] != -1) {
            return dp[index][amt];
        }

        int ans = 0;

        if (coins[index] <= amt) {
            ans += fun(index, amt - coins[index]) + fun(index + 1, amt);
        }

        dp[index][amt] = ans;
        return ans;
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.coins = coins;
        dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, amount);
    }
}
