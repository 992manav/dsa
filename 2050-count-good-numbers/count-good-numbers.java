class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1_000_000_007L;
        long no_of_even = n / 2 + n % 2;
        long no_of_odd = n - no_of_even;

        long even = modPow(5, no_of_even, mod);
        long odd = modPow(4, no_of_odd, mod);

        return (int)((even * odd) % mod);
    }

    private long modPow(long base, long exp, long mod) {
    long result = 1;
    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % mod;
            exp--; // subtract 1
        } else {
            base = (base * base) % mod;
            exp >>= 1; // divide by 2
        }
    }
    return result;
}

}
