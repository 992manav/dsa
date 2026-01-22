import java.util.*;

class Solution {

    boolean check(List<Integer> lst) {

        for (int i = 0; i < lst.size() - 1; i++) {
            if (lst.get(i + 1) < lst.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {

        int ops = 0;

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
        }

        while (!check(lst)) {

            int min = Integer.MAX_VALUE;
            int min_index = -1;

            for (int i = 0; i < lst.size() - 1; i++) {
                int sum = lst.get(i) + lst.get(i + 1);
                if (sum < min) {
                    min = sum;
                    min_index = i;
                }
            }

            lst.remove(min_index);
            lst.remove(min_index);
            lst.add(min_index, min);

            ops++;
        }

        return ops;
    }
}
