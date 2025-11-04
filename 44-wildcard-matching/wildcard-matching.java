class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[len1][len2] = 1;
        for (int j = len2 - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') dp[len1][j] = dp[len1][j + 1];
            else dp[len1][j] = 0;
        }
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                char c = p.charAt(j);
                char d = s.charAt(i);
                boolean ans;
                if (c == d || c == '?') ans = dp[i + 1][j + 1] == 1;
                else if (c == '*') {
                    boolean notEnd = dp[i][j + 1] == 1;
                    boolean end = dp[i + 1][j] == 1;
                    ans = notEnd || end;
                } else ans = false;
                dp[i][j] = ans ? 1 : 0;
            }
        }
        return dp[0][0] == 1;
    }
}
