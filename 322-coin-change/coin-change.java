class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1. Create the DP array
        int[] dp = new int[amount + 1]; // Create an array to store minimum coin counts. The size is amount + 1 because we want an index for amount 0 to amount

        // 2. Initialize the DP array
        Arrays.fill(dp, amount + 1);  // Initialize to "infinity" (a value larger than any possible answer).  This means initially we assume it's impossible to make any amount (except 0).
        dp[0] = 0;                     // Base case:  We need 0 coins to make an amount of 0.  Important!

        // 3. Iterate through the amounts and coins
        for (int i = 1; i <= amount; i++) {   // Iterate through each possible amount (from 1 to the target amount)
            for (int coin : coins) {          // For each amount, try using each available coin
                if (coin <= i) {             // Check if the current coin's value is small enough to be used for the current amount
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // This is the core DP step:
                                                                 // * `dp[i - coin]`: The minimum coins needed to make the amount *before* using the current coin.
                                                                 // * `+ 1`: We add 1 because we're using the current coin.
                                                                 // * `Math.min()`:  We keep the *smallest* value - the one that gives us the fewest coins.
                }
            }
        }

        // 4. Return the result
        return (dp[amount] > amount) ? -1 : dp[amount]; // If dp[amount] is still greater than amount, it means we couldn't make the amount, so return -1. Otherwise, return the minimum number of coins.
    }
}