import java.util.*;

class Solution {

    int[] present;
    int[] future;
    List<Integer>[] graph;

    int[][][][] dp;        // dp[node][budget][flag] -> int[]
    boolean[][][] vis;

    int[] init(int budget) {
        return new int[budget + 1];
    }

    int[] mergeChoice(int[] choice, int[] arr, int budget) {

        int[] temp = init(budget);

        for (int paisa = 0; paisa <= budget; paisa++) {
            int max_profit = 0;
            for (int pehlanepaisa = 0; pehlanepaisa <= paisa; pehlanepaisa++) {
                int bijanepaisa = paisa - pehlanepaisa;
                int val = choice[pehlanepaisa] + arr[bijanepaisa];
                if (val > max_profit) max_profit = val;
            }
            temp[paisa] = max_profit;
        }
        return temp;
    }

    int[] fun(int node, int budget, boolean flag) {

        int f = flag ? 1 : 0;

        if (vis[node][budget][f])
            return dp[node][budget][f];

        vis[node][budget][f] = true;

        int buyprice = present[node];
        if (flag) buyprice /= 2;

        int sellprice = future[node];
        int profit = sellprice - buyprice;

        List<Integer> children = graph[node];

        // leaf node
        if (children.size() == 0) {
            int[] res = init(budget);
            for (int b = buyprice; b <= budget; b++) {
                res[b] = profit;
            }
            dp[node][budget][f] = res;
            return res;
        }

        // choice 1: parent does NOT buy
        int[] choice1 = init(budget);
        for (int child : children) {
            int[] arr = fun(child, budget, false);
            choice1 = mergeChoice(choice1, arr, budget);
        }

        // choice 2: parent buys
        int[] choice2 = init(budget);
        if (budget >= buyprice) {

            int newBudget = budget - buyprice;

            int[] temp = init(newBudget);
            for (int child : children) {
                int[] arr = fun(child, newBudget, true);
                temp = mergeChoice(temp, arr, newBudget);
            }

            for (int i = 0; i <= newBudget; i++) {
                choice2[i + buyprice] = temp[i] + profit;
            }
        }

        int[] res = init(budget);
        for (int i = 0; i <= budget; i++) {
            res[i] = Math.max(choice1[i], choice2[i]);
        }

        dp[node][budget][f] = res;
        return res;
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] edges, int budget) {

        this.present = present;
        this.future = future;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
        }

        dp = new int[n][budget + 1][2][];
        vis = new boolean[n][budget + 1][2];

        int[] ans = fun(0, budget, false);

        int best = 0;
        for (int x : ans) best = Math.max(best, x);
        return best;
    }
}
