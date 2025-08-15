import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    int divide_all_power(int num, int i) {
        while (num % i == 0) {
            num = num / i;
        }
        return num;
    }

    void find_prime_factors(int num) {
        if (num % 2 == 0) {
            set.add(2);
            num = divide_all_power(num, 2);
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                set.add(i);
                num = divide_all_power(num, i);
            }
        }

        if (num > 1) { 
            set.add(num);
        }
    }

    public int distinctPrimeFactors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            find_prime_factors(nums[i]);
        }
        return set.size();
    }
}
