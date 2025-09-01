import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        int i = 0;
        int j = 0;

        int n = nums.length;
        long pairs = 0;
        long count = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        while (i < n && j < n) {
            int num = nums[j];
            if (freqMap.containsKey(num)) {
                pairs += freqMap.get(num);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // ✅ keep shrinking until pairs < k
            while (pairs >= k) {
                count += n - j;

                int remove = nums[i];
                int removePairs = freqMap.get(remove) - 1;

                freqMap.put(remove, freqMap.get(remove) - 1);
                pairs -= removePairs;
                i++;
            }
            j++;
        }
        return count;
    }
}
