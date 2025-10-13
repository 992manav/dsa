import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {

        int n = nums.size();
        int[] prefix = new int[n]; // fix size to n, not n+1

        prefix[0] = (nums.get(0) % mod == k) ? 1 : 0;

        for (int i = 1; i < n; i++) { 
            prefix[i] = prefix[i - 1] + ((nums.get(i) % mod == k) ? 1 : 0); 
        }

        long count = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L); // prefix remainder 0 appears once

        for (int i = 0; i < n; i++) { // loop from 0 to n-1
            int rem = prefix[i] % mod;
            if (rem < 0) rem += mod;

            int target = (rem - k + mod) % mod;

            count += map.getOrDefault(target, 0L);

            map.put(rem, map.getOrDefault(rem, 0L) + 1);
        }

        return count;
    }
}
