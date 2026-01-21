import java.util.*;

class Solution {

    List<List<Integer>> piles;
    int len;
    int[][][] dp;

    int fun(int p_i, int index, int k) {

        if (k == 0 || p_i == len) {
            return 0;
        }

        if (dp[p_i][index][k] != -1) {
            return dp[p_i][index][k];
        }

        int road1 = 0;
        int road2 = 0;

        if (index < piles.get(p_i).size()) {
            int curr = piles.get(p_i).get(index);

            road1 = fun(p_i, index + 1, k - 1) + curr;
            road2 = fun(p_i + 1, 0, k - 1) + curr;
        }

        int road3 = fun(p_i + 1, 0, k);

        int take_max = Math.max(road1, road2);
        dp[p_i][index][k] = Math.max(road3, take_max);

        return dp[p_i][index][k];
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        this.piles = piles;
        this.len = piles.size();

        int maxPileSize = 0;
        for (List<Integer> p : piles) {
            maxPileSize = Math.max(maxPileSize, p.size());
        }

        dp = new int[len][maxPileSize + 1][k + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= maxPileSize; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, 0, k);
    }
}
