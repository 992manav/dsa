import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // =======================
        // FIRST PASS: atMost(k)
        // =======================

        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {

            // window ke right side element add kar rahe
            int cur = nums[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            // jab distinct > k ho jaaye
            // tab left se window shrink karni padegi
            while (map.size() > k) {
                int left = nums[i];
                map.put(left, map.get(left) - 1);

                // frequency zero hui toh element hata do
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            // yahan window [i..j] valid hai (≤ k distinct)
            // j pe end hone wale saare subarrays count karo
            count += j - i + 1;

            j++;
        }

        // =========================
        // SECOND PASS: atMost(k-1)
        // =========================

        i = 0;
        j = 0;
        map.clear();

        while (j < n) {

            int cur = nums[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            // jab distinct > k-1 ho jaaye
            // window shrink karo
            while (map.size() > k - 1) {
                int left = nums[i];
                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            // yahan window [i..j] valid hai (≤ k-1 distinct)
            // in subarrays ko total se minus karna hai
            count -= j - i + 1;

            j++;
        }

        // finally: atMost(k) - atMost(k-1)
        return count;
    }
}
