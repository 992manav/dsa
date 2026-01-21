import java.util.*;

class Solution {

    List<List<Integer>> piles;
    int len;
    int[][] dp;

    int fun(int p_i, int k) {

        if (k == 0 || p_i == len) {
            return 0;
        }

        if (dp[p_i][k] != -1) {
            return dp[p_i][k];
        }

        int best = fun(p_i + 1, k);

        int currSum = 0;
        int limit = Math.min(k, piles.get(p_i).size());

        for (int i = 0; i < limit; i++) {
            currSum += piles.get(p_i).get(i);
            int take = currSum + fun(p_i + 1, k - (i + 1));
            best = Math.max(best, take);
        }

        dp[p_i][k] = best;
        return best;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        this.piles = piles;
        this.len = piles.size();

        dp = new int[len][k + 1];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, k);
    }
}
