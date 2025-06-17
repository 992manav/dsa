import java.util.Arrays;

class Solution {

    public int countPrimes(int n) {

        long[] primes = new long[n];
        Arrays.fill(primes, 1);  // Fill array with 1s

        long count = 0; // Use long for count

        for (long i = 2; i < n; i++) {

            if (primes[(int)i] == 1) {

                for (long j = i * i; j < n; j += i) {
                    primes[(int)j] = 0;  // Mark multiples of i as not prime
                }

                count++;
            }
        }

        return (int)count; // Return as int since method return type is int
    }
}
