import java.util.Arrays;

class Solution {

    int[] cost;
    int[] dp;

    int fun(int idx) {
        if (idx == cost.length - 2 || idx == cost.length - 1) {
            return cost[idx];
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int one = fun(idx + 1);
        int two = fun(idx + 2);
        return dp[idx] = Math.min(one, two) + cost[idx];
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        this.cost = cost;
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(fun(0), fun(1));
    }
}
