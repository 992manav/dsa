class Solution {

    int[][] dp;
    String a, b;

    int fun(int i, int j) {
        // agar koi string khatam thai gai to LCS zero
        if (i == a.length() || j == b.length()) return 0;

        // jo pehla thi compute karelu hoy to direct return
        if (dp[i][j] != -1) return dp[i][j];

        // agar character match thai gaya
        if (a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + fun(i + 1, j + 1);
            return dp[i][j];
        }

        // match nai hoy to next possibilities ma thi max lai leva nu
        int op1 = fun(i + 1, j);
        int op2 = fun(i, j + 1);

        if (op1 > op2) dp[i][j] = op1;
        else dp[i][j] = op2;

        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        a = text1;
        b = text2;
        dp = new int[a.length()][b.length()];

        // dp fill -1 so we know kon compute nathi thayu
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0);
    }
}
