import java.util.*;

public class Solution {

    // Global DP array (max n = 10000)
    static int[] dp = new int[10001];

    public int numSquares(int n) {

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int num = 1; num * num <= n; num++) {

            int square = num * num;

            for (int target = square; target <= n; target++) {
                int remaining = target - square;

                if (dp[remaining] != Integer.MAX_VALUE) {
                    dp[target] = Math.min(dp[target], dp[remaining] + 1);
                }
            }
        }

        return dp[n];
    }
}
