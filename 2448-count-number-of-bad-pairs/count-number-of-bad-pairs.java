import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = i - nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long goodPairs = 0;
        for (int value : map.values()) {
            if (value > 1) {
                goodPairs += (long) value * (value - 1) / 2;
            }
        }
        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}
