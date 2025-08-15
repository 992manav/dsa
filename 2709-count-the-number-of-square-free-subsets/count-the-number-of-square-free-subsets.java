import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {

    List<Integer> lst = new ArrayList<>();
    int n;
    final int MOD = 1_000_000_007;
    int[][] dp;
    int[] primeList = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    int find_divisors(int num) {
        int mask = 0;
        for (int pIndex = 0; pIndex < primeList.length; pIndex++) {
            int p = primeList[pIndex];
            int count = 0;
            while (num % p == 0) {
                num /= p;
                count++;
            }
            if (count > 1) return -1; 
            if (count == 1) mask |= (1 << pIndex);
        }
        return mask;
    }

    boolean check(int xor, int curr) {
        return (xor & curr) == 0;
    }

    int fun(int i, int xor) {
        if (i == n) {
            return xor != 0 ? 1 : 0;
        }
        if (dp[i][xor] != -1) return dp[i][xor];
        int take = 0;
        if (check(xor, lst.get(i))) {
            take = fun(i + 1, xor | lst.get(i));
        }
        int skip = fun(i + 1, xor);
        return dp[i][xor] = (int) (((long) take + skip) % MOD);
    }

    public int squareFreeSubsets(int[] nums) {
        List<Integer> divisors = new ArrayList<>();
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
                continue;
            }
            int mask = find_divisors(num);
            if (mask != -1) {
                divisors.add(mask);
            }
        }
        lst = divisors;
        n = lst.size();
        dp = new int[n + 1][1 << 10]; 
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long subsetsWithoutOnes = fun(0, 0);
        long pow = 1;
        for (int i = 0; i < countOnes; i++) {
            pow = (pow * 2) % MOD;
        }
        long totalWays = (subsetsWithoutOnes * pow) % MOD;
        totalWays = (totalWays + pow - 1 + MOD) % MOD;
        return (int) totalWays;
    }
}
