class Solution {

    long mod = 1_000_000_007L;

    public long myPow(long x, long exp) {
        long res = 1;
        while (exp != 0) {
            if (exp % 2 == 0) {
                x = (x * x) % mod;
                exp /= 2;
            } else {
                res = (res * x) % mod;
                exp--;
            }
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = myPow(5, evenCount);
        long oddWays = myPow(4, oddCount);

        return (int) ((evenWays * oddWays) % mod);
    }
}
