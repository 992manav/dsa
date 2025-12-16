import java.util.*;

class Solution {

    int[] present;
    // present[node] = aa node par stock buy karva mate ketla paisa lage
    // aa price discount thi change thai shake (flag par depend)

    int[] future;
    // future[node] = aa node par stock sell kariye to ketla paisa male

    List<Integer>[] graph;
    // graph[node] = aa node na direct children
    // hierarchy tree structure

    int[][][][] dp;
    // dp[node][budget][f]
    // f = 0 => flag false
    // f = 1 => flag true
    //
    // dp[node][budget][f] ek int[] chhe:
    // index = exact ketla paisa vaprya
    // value = aa paisa vapri ne maximum profit

    boolean[][][] vis;
    // vis[node][budget][f] = aa state already calculate thai gai chhe ke nai
    // repeat calculation avoid karva mate

    int[] init(int budget) {
        // aa function ek simple helper chhe
        // budget + 1 size no array banave
        // default badha value 0
        return new int[budget + 1];
    }

    int[] mergeChoice(int[] choice, int[] arr, int budget) {

        // choice = pehla sudhi merge thai gayela children no profit
        // arr    = current ek child no profit array
        //
        // aa function nu kaam:
        // be arrays ne knapsack style combine karvu

        int[] temp = init(budget);

        // total paisa ketla vapraya chhe
        for (int paisa = 0; paisa <= budget; paisa++) {

            int max_profit = 0;

            // paisa ne be part ma vaachie
            for (int pehlanepaisa = 0; pehlanepaisa <= paisa; pehlanepaisa++) {

                int bijanepaisa = paisa - pehlanepaisa;

                // pehla part choice mathi
                // bija part arr mathi
                int val = choice[pehlanepaisa] + arr[bijanepaisa];

                // best combination choose kariye
                if (val > max_profit) {
                    max_profit = val;
                }
            }

            temp[paisa] = max_profit;
        }

        return temp;
    }

    int[] fun(int node, int budget, boolean flag) {

        // flag ne integer ma convert karyo
        // kem ke dp array integer index vapre
        int f = flag ? 1 : 0;

        // jo aa state already calculate thai chuki hoy
        // to direct dp mathi answer
        if (vis[node][budget][f]) {
            return dp[node][budget][f];
        }

        // aa state ne visited mark kari
        vis[node][budget][f] = true;

        // aa node no buy price
        int buyprice = present[node];

        // jo parent e buy karyu hoy (flag true)
        // to aa node ne discount male
        if (flag) {
            buyprice = buyprice / 2;
        }

        int sellprice = future[node];

        // aa node par buy + sell kari ne net profit
        int profit = sellprice - buyprice;

        List<Integer> children = graph[node];

        // ================= LEAF NODE =================
        // jo aa node na koi children nathi
        if (children.size() == 0) {

            int[] res = init(budget);

            // jo budget buyprice karta ochhu chhe
            // to stock buy nai thai shake => profit 0
            //
            // jo budget >= buyprice
            // to aa node thi fixed profit male
            for (int b = buyprice; b <= budget; b++) {
                res[b] = profit;
            }

            dp[node][budget][f] = res;
            return res;
        }

        // ================= CHOICE 1 =================
        // aa node buy nathi karto
        // etle:
        // - budget same rahe
        // - children ne discount nai male
        int[] choice1 = init(budget);

        for (int child : children) {

            // child ne same budget male
            // flag false pass thay
            int[] arr = fun(child, budget, false);

            // current result ne child sathe merge kariye
            choice1 = mergeChoice(choice1, arr, budget);
        }

        // ================= CHOICE 2 =================
        // aa node buy kare chhe
        int[] choice2 = init(budget);

        // buy karva mate paisa hova joie
        if (budget >= buyprice) {

            // buyprice cut kari ne remaining budget
            int newBudget = budget - buyprice;

            int[] temp = init(newBudget);

            for (int child : children) {

                // aa case ma child ne discount male
                int[] arr = fun(child, newBudget, true);

                // badha children ne combine kariye
                temp = mergeChoice(temp, arr, newBudget);
            }

            // aa node no potano profit add kariye
            for (int i = 0; i <= newBudget; i++) {
                choice2[i + buyprice] = temp[i] + profit;
            }
        }

        // ================= FINAL =================
        // same paisa par:
        // choice1 vs choice2 mathi je vadhu hoy te rakhiye
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

        // graph initialize
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // edges mathi tree build kariye
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
        }

        dp = new int[n][budget + 1][2][];
        vis = new boolean[n][budget + 1][2];

        // root node = 0
        // start ma koi discount nathi
        int[] ans = fun(0, budget, false);

        // maximum profit nikaliye
        int best = 0;
        for (int x : ans) {
            best = Math.max(best, x);
        }

        return best;
    }
}
