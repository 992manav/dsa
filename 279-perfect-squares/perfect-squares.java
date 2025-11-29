import java.util.*;

public class Solution {

    // Global dp array — max 10000 sudhi direct use kari sakiye
    static int[] dp = new int[10001];

    public int numSquares(int n) {

        // Start ma badha value ne bahu moto number muki didho
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 0 banava 0 squares joiye
        dp[0] = 0;

        // Badha perfect square try karisu: 1, 4, 9, 16...
        for (int num = 1; num * num <= n; num++) {

            int square = num * num; // aa number nu square

            // Aa square thi n sudhi badha target update karvana
            for (int target = square; target <= n; target++) {

                // Ek square use kari lidho — baki ketlu rahyu?
                int remaining = target - square;

                // Jo remaining index reachable hoy to dp update karo
                if (dp[remaining] != Integer.MAX_VALUE) {

                    // Old dp[target] vs new dp[remaining] + 1
                    dp[target] = Math.min(dp[target], dp[remaining] + 1);
                }
            }
        }

        // n banava minimum ketla perfect square joiye — final answer
        return dp[n];
    }
}
