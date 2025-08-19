import java.util.*;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int index = 0;
        lst.add(0); 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lst.set(index, lst.get(index) + 1);
            } else if (i > 0 && nums[i - 1] == 0) {
                index++;
                lst.add(0);
            }
        }

        long count = 0;
        for (int i = 0; i < lst.size(); i++) {
            int n = lst.get(i);
            count += (long) n * (n + 1) / 2;
        }
        return count;
    }
}
