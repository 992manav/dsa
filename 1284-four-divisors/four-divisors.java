class Solution {
    public int sumFourDivisors(int[] nums) {

        /*
         APPROACH OVERVIEW (GUJLISH):

         Aa approach ne "Sieve of Eratosthenes jevi DIVISOR SIEVE" kehvay.

         Normally jo tame ek-ek number mate divisors find karo,
         to sqrt(n) sudhi loop chalavvo pade → slow thai jay.

         Sieve idea:
         - Ek vaar badha numbers mate divisors precompute kari lo
         - Pachhi direct answer use kari sako
        */

        // nums array ni length
        int n = nums.length;

        /*
         Step 1: nums array ma thi maximum element find kariye

         Karan:
         - Sieve ne 1 thi max sudhi chalavsu
         - fac ane fac_freq arrays ni size max+1 rakhvi pade
        */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }

        /*
         fac[x] = x na badha divisors no SUM store karse
         Example: x = 21 → fac[21] = 1 + 3 + 7 + 21 = 32
        */
        int[] fac = new int[max + 1];

        /*
         fac_freq[x] = x ne ketla divisors chhe te COUNT store karse
         Example: x = 21 → fac_freq[21] = 4
        */
        int[] fac_freq = new int[max + 1];

        /*
         Step 2: DIVISOR SIEVE

         i ne divisor mani ne eni badhi multiples par jase

         i = 1 → 1 divides all numbers
         i = 2 → 2 divides 2,4,6,8...
         i = 3 → 3 divides 3,6,9...

         Aa rite:
         - fac[j] ma i add thai
         - fac_freq[j] ma divisor count +1 thai
        */
        for (int i = 1; i <= max; i++) {

            // j = i, 2i, 3i ... etle i na badha multiples
            for (int j = i; j <= max; j += i) {

                // i j no divisor chhe
                // etle divisor sum ma i add karo
                fac[j] += i;

                // divisor count increment karo
                fac_freq[j]++;
            }
        }

        /*
         Step 3: Original nums array traverse kariye

         Je number na EXACT 4 divisors hoy,
         ena badha divisors no sum answer ma add kariye
        */
        int sum = 0;

        for (int i = 0; i < n; i++) {

            /*
             EXACT 4 divisors condition important chhe

             Math fact:
             - Koi number na 4 divisors hoy to:
               1) p^3 (p prime)  → example: 8 → {1,2,4,8}
               2) p * q (p,q prime) → example: 21 → {1,3,7,21}
            */
            if (fac_freq[nums[i]] == 4) {

                // eni badha divisors no sum add kariye
                sum += fac[nums[i]];
            }
        }

        /*
         Final answer return
        */
        return sum;
    }
}

/*
 TIME COMPLEXITY ANALYSIS (GUJLISH):

 Let max = maximum element in nums

 Sieve loop:
 - i = 1 to max
 - j moves as multiples → max/i steps

 Total complexity:
 = max/1 + max/2 + max/3 + ...
 ≈ O(max log max)

 nums traversal:
 = O(n)

 Overall Time Complexity:
 👉 O(max log max + n)

 SPACE COMPLEXITY:
 - fac array → O(max)
 - fac_freq array → O(max)

 Overall Space:
 👉 O(max)
*/
