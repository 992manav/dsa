import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {

        int n = nums.size();
        long count = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L); 

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums.get(i) % mod == k) ? 1 : 0;  
            int rem = sum % mod;
            if (rem < 0) rem += mod;

            int target = (rem - k + mod) % mod;

            count += map.getOrDefault(target, 0L);

            map.put(rem, map.getOrDefault(rem, 0L) + 1);
        }

        return count;
    }
}
