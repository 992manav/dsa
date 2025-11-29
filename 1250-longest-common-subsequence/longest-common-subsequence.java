class Solution {

    String s, t;
    int[][] dp;

    int check(char c, int index) {
        for (int i = index + 1; i < t.length(); i++) {
            if (t.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    int fun(int i, int j) {
        if (i >= s.length()) return 0;

        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        char c = s.charAt(i);

        int take = 0;
        int index = check(c, j);
        if (index != -1) {
            take = 1 + fun(i + 1, index);
        }

        int skip = fun(i + 1, j);

        return dp[i][j + 1] = Math.max(take, skip);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        s = text1;
        t = text2;

        dp = new int[s.length()][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, -1);
    }
}
