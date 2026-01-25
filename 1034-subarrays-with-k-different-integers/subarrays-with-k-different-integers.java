import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            int cur = nums[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.size() > k) {
                int left = nums[i];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            count += j - i + 1;
            j++;
        }

        i = 0;
        j = 0;
        map.clear();

        while (j < n) {
            int cur = nums[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.size() > k - 1) {
                int left = nums[i];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            count -= j - i + 1;
            j++;
        }

        return count;
    }
}
