import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case for subarrays starting at index 0

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                sum += 1;
            }

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
