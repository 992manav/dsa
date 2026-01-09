import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        int count = 0;
        int ele = -1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                set.add(nums[i]);
            }
        }

        set.add(ele);

        for (Integer x : set) {
            count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == x) {
                    count++;
                }
            }
            if (count == nums.length / 2) {
                return x;
            }
        }

        return -1;
    }
}
