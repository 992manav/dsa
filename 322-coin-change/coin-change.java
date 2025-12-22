class Solution {
    public int coinChange(int[] coins, int amount) {

        // 1. DP array banaviye
        // dp[i] = amount i banava mate minimum ketla coins joie
        int[] dp = new int[amount + 1];

        // 2. DP initialize kariye
        // badha values ne pehla ek mota number aapiye (infinity jaiso)
        // etle pehla assume kariye ke koi amount banavo possible nathi
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // base case
        // amount 0 banava mate 0 coins joie
        dp[0] = 0;

        // 3. DP fill kariye
        // i = current amount je banavvano chhe
        for (int i = 1; i <= amount; i++) {

            // darek coin try kariye
            for (int coin : coins) {

                // jo coin ni value i karta nani ke equal hoy
                // etle aa coin use kari sakay
                if (coin <= i) {

                    // dp[i - coin] = pehla ketla coins thi baki amount banyo
                    // +1 = current coin add kariye
                    // min levi chhe kem ke minimum coins joie
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 4. Answer return kariye
        // jo dp[amount] haji pan mota number chhe
        // etle amount banavo possible nathi -> -1
        if (dp[amount] > amount) {
            return -1;
        }

        // nahi to minimum coins return kariye
        return dp[amount];
    }
}
