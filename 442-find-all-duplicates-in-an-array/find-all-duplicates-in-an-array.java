import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();

        int max = nums.length;
        for (int i = 0; i < max; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (index >= max) {
                continue;
            } else {
                if (nums[index] < 0) {
                    lst.add(index + 1);
                }
                nums[index] *= -1;
            }
        }

        return lst;
    }
}
