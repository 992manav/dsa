class Solution {
    static final int MOD = 1000000007;
    static final int MAXN = 100005;
    static long[] pow10 = new long[MAXN];
    static boolean built = false;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        if (!built) {
            pow10[0] = 1;
            for (int i = 1; i < MAXN; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;
            built = true;
        }

        int[] prefix_sum = new int[n];
        int[] prefix_digits = new int[n];
        long[] prefix_number = new long[n];

        int x0 = s.charAt(0) - '0';
        prefix_sum[0] = x0;
        prefix_digits[0] = x0 > 0 ? 1 : 0;
        prefix_number[0] = x0 > 0 ? x0 : 0;

        for (int i = 1; i < n; i++) {
            int x = s.charAt(i) - '0';
            prefix_sum[i] = prefix_sum[i - 1] + x;
            if (x > 0) {
                prefix_digits[i] = prefix_digits[i - 1] + 1;
                prefix_number[i] = (prefix_number[i - 1] * 10 + x) % MOD;
            } else {
                prefix_digits[i] = prefix_digits[i - 1];
                prefix_number[i] = prefix_number[i - 1];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum;
            int digits;
            long numr;
            long numl;

            if (l == 0) {
                sum = prefix_sum[r];
                digits = prefix_digits[r];
                numr = prefix_number[r];
                numl = 0;
            } else {
                sum = prefix_sum[r] - prefix_sum[l - 1];
                digits = prefix_digits[r] - prefix_digits[l - 1];
                numr = prefix_number[r];
                numl = prefix_number[l - 1];
            }

            long sub = (numl * pow10[digits]) % MOD;
            long x = (numr - sub) % MOD;
            if (x < 0) x += MOD;

            long val = ((x % MOD) * (sum % MOD)) % MOD;
            if (val < 0) val += MOD;

            ans[i] = (int) val;
        }

        return ans;
    }
}
