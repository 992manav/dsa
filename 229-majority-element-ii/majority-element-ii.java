import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = nums.length / 3;
        int i = 0;
        int j = 1;
        List<Integer> lst = new ArrayList<>();

        while (j <= nums.length) {
            if (j == nums.length || nums[j] != nums[i]) {
                int diff = j - i;
                if (diff > count) {
                    lst.add(nums[i]);
                }
                i = j;
            }
            j++;
        }

        return lst;
    }
}
