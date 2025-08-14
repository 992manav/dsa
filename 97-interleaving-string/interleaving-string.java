class Solution {
    String s1, s2, s3;
    Boolean[][] dp; // memo table

    boolean check(int i, int j, int k) {
        if (k == s3.length()) {
            return (i == s1.length() && j == s2.length());
        }

        if (dp[i][j] != null) return dp[i][j]; // already computed

        boolean ans = false;
        char c = s3.charAt(k);

        if (i < s1.length() && c == s1.charAt(i)) {
            ans = ans || check(i + 1, j, k + 1);
        }
        if (j < s2.length() && c == s2.charAt(j)) {
            ans = ans || check(i, j + 1, k + 1);
        }

        return dp[i][j] = ans;
    }

    public boolean isInterleave(String a, String b, String c) {
        s1 = a;
        s2 = b;
        s3 = c;

        if (c.length() != (a.length() + b.length())) return false;

        dp = new Boolean[s1.length() + 1][s2.length() + 1]; // initialize memo
        return check(0, 0, 0);
    }
}
