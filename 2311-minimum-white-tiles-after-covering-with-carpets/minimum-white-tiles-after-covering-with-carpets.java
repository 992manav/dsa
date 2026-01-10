class Solution {

    int len;        // floor string ni total length
    int cLen;       // carpet ni length
    int[] prefix;   // prefix[i] = i index thi cLen length ma ketla white tiles ('1') che
    int[][] dp;     // dp[i][count] = max white tiles cover kari sakai from index i with count carpets

    int fun(int i, int count) {

        // base case:
        // jo index floor ni bahar jai gayo to cover karva mate kai nathi
        if (i >= len) {
            return 0;
        }

        // jo carpets baki nathi, to cover kai nathi kari sakta
        if (count == 0) {
            return 0;
        }

        // jo aa state pehla thi calculate kari chuki che to direct return
        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        // option 1: aa index par carpet mukie
        // to cLen tiles skip thase ane aa window ma je white tiles che te cover thase
        int take = fun(i + cLen, count - 1) + prefix[i];

        // option 2: aa index skip kari ne next index par try kariye
        int skip = fun(i + 1, count);

        // maximum white tiles cover kari sakta hoy te store kariye
        dp[i][count] = Math.max(take, skip);
        return dp[i][count];
    }

    public int minimumWhiteTiles(String s, int count, int cLen) {

        this.len = s.length();   // total tiles
        this.cLen = cLen;        // carpet length

        prefix = new int[len];

        // prefix array calculate kariye
        // prefix[i] batave che ke i thi carpet mukta ketla '1' cover thase
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < Math.min(i + cLen, len); j++) {
                sum += s.charAt(j) - '0'; // '1' -> 1, '0' -> 0
            }
            prefix[i] = sum;
        }

        // total white tiles count kariye
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += s.charAt(i) - '0';
        }

        // dp array initialize kariye
        // dimensions: [len][count + 1]
        dp = new int[len][count + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= count; j++) {
                dp[i][j] = -1; // -1 means state yet compute nathi kari
            }
        }

        // fun(0, count) = maximum white tiles je carpets thi cover kari sakai
        // minimum white tiles = total - covered
        return Math.max(0, total - fun(0, count));
    }
}
