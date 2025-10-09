import java.util.*;

class Solution {

    private List<String> words;
    private int[][] dp;
    private int n;

    // Check if words[i] can follow words[j] in the chain
    private boolean canTake(int i, int j) {
        String a = words.get(i); // longer
        String b = words.get(j); // shorter
        if (a.length() != b.length() + 1) return false;

        int p1 = 0, p2 = 0;
        boolean skipped = false;
        while (p1 < a.length() && p2 < b.length()) {
            if (a.charAt(p1) == b.charAt(p2)) {
                p1++; p2++;
            } else {
                if (skipped) return false;
                skipped = true;
                p1++;
            }
        }
        return true;
    }

    private int helper(int i, int prevIdx) {
        if (i == n) return 0;
        if (dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];

        int notTake = helper(i + 1, prevIdx);
        int take = 0;

        if (prevIdx == -1 || canTake(i, prevIdx)) {
            take = 1 + helper(i + 1, i);
        }

        return dp[i][prevIdx + 1] = Math.max(take, notTake);
    }

    public int longestStrChain(String[] wordsArr) {
        words = Arrays.asList(wordsArr);
        n = words.size();

        // Sort words by length
        Collections.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(0, -1);
    }

  
}
