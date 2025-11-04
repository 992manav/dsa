class Solution {

    String s, p;
    int len1, len2;
    int[][] dp;   // -1 = unknown, 0 = false, 1 = true

    boolean fun(int i, int j) {

        if (i == len1) {
            if (j == len2) return true;
            for (int k = j; k < len2; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (j == len2) return false;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        char c = p.charAt(j);
        char d = s.charAt(i);

        boolean ans;

        if (Character.isLetter(c)) {
            if (c != d) ans = false;
            else ans = fun(i + 1, j + 1);

        } else if (c == '?') {
            ans = fun(i + 1, j + 1);

        } else {  // '*'
            boolean notend = fun(i, j + 1);
            boolean end = fun(i + 1, j);
            ans = end || notend;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.len1 = s.length();
        this.len2 = p.length();
        this.dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                dp[i][j] = -1;
            }
        }

        return fun(0, 0);
    }
}
