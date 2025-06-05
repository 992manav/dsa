import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> final_list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicate i
            }

            if (nums[i] > 0) {
                break;
            }

            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[j] + nums[k];

                if (sum == target) {

                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(nums[k]);
                    final_list.add(lst);

                    while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                        j++;
                    }

                    while (k > j + 1 && nums[k - 1] == nums[k]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum > target) {

                    while (k - 1 > j && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    k--;  // default decrement when not skipping duplicates

                } else {

                    while (j + 1 < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;  // default increment when not skipping duplicates

                }

            }
        }

        return final_list;
    }
}
