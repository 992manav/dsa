import java.util.*;

class Solution {

    int binary_search(TreeMap<Integer, TreeSet<Integer>> map, int target) {

        for (Integer len : map.keySet()) {
            TreeSet<Integer> set = map.get(len);
            if (set.lower(target) != null) {
                return len + 1;
            }
        }

        return 1;
    }

    public int lengthOfLIS(int[] nums) {

        TreeMap<Integer, TreeSet<Integer>> map =
            new TreeMap<>(Collections.reverseOrder());

        TreeSet<Integer> s = new TreeSet<>();
        s.add(nums[0]);
        map.put(1, s);

        int max_len = 1;

        for (int i = 1; i < nums.length; i++) {
            int len = binary_search(map, nums[i]);

            if (map.containsKey(len)) {
                map.get(len).add(nums[i]);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(nums[i]);
                map.put(len, set);
            }

            max_len = Math.max(max_len, len);
        }

        return max_len;
    }
}
