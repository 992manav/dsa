import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important: remainder 0 initially appears once

        for (int i = 1; i <= n; i++) {
            int remainder = prefix[i] % k;
            if (remainder < 0) remainder += k; // handle negative numbers

            if (map.containsKey(remainder)) {
                total += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return total;
    }
}
