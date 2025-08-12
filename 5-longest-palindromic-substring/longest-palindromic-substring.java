class Solution {

    String s;
    int[][] dp;

    int check_pali(int i, int j) {
        if (i >= j) return 1; // base case

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = 0;
        }

        return dp[i][j] = check_pali(i + 1, j - 1);
    }

    public String longestPalindrome(String s) {
        this.s = s;
        int n = s.length();
        dp = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                dp[x][y] = -1;
            }
        }

        int max_len = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (check_pali(i, j) == 1) {
                    int len = j - i + 1;
                    if (len > max_len) {
                        max_len = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
}
