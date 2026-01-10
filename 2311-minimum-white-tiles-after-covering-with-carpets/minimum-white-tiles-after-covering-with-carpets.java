class Solution {

    int len;
    int cLen;
    int[] prefix;
    int[][] dp;

    int fun(int i, int count) {

        if (i >= len) {
            return 0;
        }

        if (count == 0) {
            return 0;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int take = fun(i + cLen, count - 1) + prefix[i];

        int skip = fun(i + 1, count);

        dp[i][count] = Math.max(take, skip);
        return dp[i][count];
    }

    public int minimumWhiteTiles(String s, int count, int cLen) {

        this.len = s.length();
        this.cLen = cLen;

        prefix = new int[len];

        // Calculate prefix for each position
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < Math.min(i + cLen, len); j++) {
                sum += s.charAt(j) - '0';
            }
            prefix[i] = sum;
        }

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += s.charAt(i) - '0';
        }

        dp = new int[len][count + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= count; j++) {
                dp[i][j] = -1;
            }
        }

        return Math.max(0, total - fun(0, count));
    }
}