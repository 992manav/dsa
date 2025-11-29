import java.util.*;

public class Solution {
    public int numSquares(int n) {
        int[] minCount = new int[n + 1];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        minCount[0] = 0;

        for (int base = 1; base * base <= n; base++) {
            int squareValue = base * base;

            for (int currentSum = squareValue; currentSum <= n; currentSum++) {
                int remaining = currentSum - squareValue;  // ← only THIS is correct
                minCount[currentSum] = Math.min(minCount[remaining] + 1, minCount[currentSum]);
            }
        }

        return minCount[n];
    }
}
