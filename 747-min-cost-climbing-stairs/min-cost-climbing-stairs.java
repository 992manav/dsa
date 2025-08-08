import java.util.Arrays;

class Solution {

    int[] cost;
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        this.cost = cost;
        int n = cost.length;
        dp = new int[n];

        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
