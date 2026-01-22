import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int count = 0;
        int max_len = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                int idx = map.get(count);
                max_len = Math.max(max_len, i - idx);
            } else {
                map.put(count, i);
            }
        }

        return max_len;
    }
}
