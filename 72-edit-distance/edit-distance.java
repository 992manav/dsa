class Solution {

    String s1;
    String s2;
    int[][] dp;

    int fun(int i, int j) {

        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int skip = Integer.MAX_VALUE;

        if (s1.charAt(i) == s2.charAt(j)) {
            skip = fun(i + 1, j + 1);
        }

        int insert = fun(i, j + 1) + 1;
        int replace = fun(i + 1, j + 1) + 1;
        int delete = fun(i + 1, j) + 1;

        dp[i][j] = Math.min(skip, Math.min(insert, Math.min(delete, replace)));
        return dp[i][j];
    }

    public int minDistance(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;

        int l1 = s1.length();
        int l2 = s2.length();

        dp = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0);
    }
}
