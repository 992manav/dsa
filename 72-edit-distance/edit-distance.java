class Solution {

    // s1 ane s2 class level par lidha chhe
    // etle recursive function ma baar-baar pass karva ni jarur nathi
    String s1;
    String s2;

    // dp[i][j] = minimum operations
    // s1.substring(i) ne s2.substring(j) banava mate
    int[][] dp;

    int fun(int i, int j) {

        // BASE CASE 1:
        // jo s1 puro thai gayo
        // to s2 na jetla characters baki chhe etla INSERT karva padse
        if (i == s1.length()) {
            return s2.length() - j;
        }

        // BASE CASE 2:
        // jo s2 puro thai gayo
        // to s1 na jetla characters baki chhe etla DELETE karva padse
        if (j == s2.length()) {
            return s1.length() - i;
        }

        // MEMOIZATION CHECK:
        // aa state pehla calculate thai chuki hoy to direct return kari do
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // skip = koi operation nathi
        // pehla MAX_VALUE mukyu chhe etle min calculation sachi rahe
        int skip = Integer.MAX_VALUE;

        // jo banne characters same chhe
        // to banne pointer aagal vadhao
        if (s1.charAt(i) == s2.charAt(j)) {
            skip = fun(i + 1, j + 1);
        }

        // INSERT operation:
        // s2[j] insert kari → j aagal vadhe
        int insert = fun(i, j + 1) + 1;

        // REPLACE operation:
        // s1[i] ne s2[j] thi replace kari → banne aagal
        int replace = fun(i + 1, j + 1) + 1;

        // DELETE operation:
        // s1[i] delete kari → i aagal vadhe
        int delete = fun(i + 1, j) + 1;

        // badha operations mathi minimum store karo
        dp[i][j] = Math.min(skip, Math.min(insert, Math.min(delete, replace)));
        return dp[i][j];
    }

    public int minDistance(String s1, String s2) {

        // input strings class variables ma store kari
        this.s1 = s1;
        this.s2 = s2;

        int l1 = s1.length();
        int l2 = s2.length();

        // IMPORTANT:
        // dp ni size string ni length jaaniya pachi j initialize karvi
        dp = new int[l1][l2];

        // dp ne -1 thi fill karo
        // -1 matlab aa state haju compute nathi thai
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                dp[i][j] = -1;
            }
        }

        // recursion start 0,0 thi
        return fun(0, 0);
    }
}
