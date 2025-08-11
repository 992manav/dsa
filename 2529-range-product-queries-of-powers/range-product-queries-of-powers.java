import java.util.*;

class Solution {
    static final int MOD = (int) 1e9 + 7;

    private static int pow2mod(int exp) {
        long res = 1, base = 2;
        while (exp > 0) {
            if ((exp & 1) != 0) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> lst = new ArrayList<>();
        int pow = 0;
        int tmp = n;
        while (tmp > 0) {
            if ((tmp & 1) != 0) lst.add(pow); // store exponent (0,1,2,...), ascending order
            pow++;
            tmp >>= 1;
        }

        int m = lst.size();
        if (m == 0) {
            int[] resEmpty = new int[queries.length];
            Arrays.fill(resEmpty, 0);
            return resEmpty;
        }

        int[] prefix = new int[m];
        prefix[0] = lst.get(0);
        for (int i = 1; i < m; i++) prefix[i] = prefix[i - 1] + lst.get(i);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int expSum = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
            res[i] = pow2mod(expSum);
        }
        return res;
    }
}
