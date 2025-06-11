import java.util.*;

class Solution {

    List<List<Integer>> final_list = new ArrayList<>();
    int n;

    void fun(int[] nums, int index) {
        if (index == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            final_list.add(temp);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < n; i++) {
            if (used.contains(nums[i])) continue;
            used.add(nums[i]);

            swap(nums, i, index);      // Swap current index with i
            fun(nums, index + 1);      // Go to next index
            swap(nums, i, index);      // Backtrack
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        fun(nums, 0);
        return final_list;
    }
}
