import java.util.*;

class Solution {

    int target;
    Set<List<Integer>> final_list = new HashSet<>();

    public void fun(List<Integer> lst, int sum, int[] nums, int starting_index) {

        if (sum == target) {
            final_list.add(new ArrayList<>(lst)); // ✅ add a copy to avoid mutation
            return;
        }

        if (starting_index >= nums.length) {
            return;
        }

        if (nums[starting_index] + sum <= target) {
            lst.add(nums[starting_index]);
            fun(lst, sum + nums[starting_index], nums, starting_index);
            fun(lst, sum + nums[starting_index], nums, starting_index + 1);
            lst.remove(lst.size() - 1); // Backtrack
        }

        fun(lst, sum, nums, starting_index + 1);
    }

    public List<List<Integer>> combinationSum(int[] num, int tar) {
        this.target = tar; // ✅ fixed variable usage
        fun(new ArrayList<>(), 0, num, 0);
        List<List<Integer>> list = new ArrayList<>(final_list);
        return list; // ✅ return correct list
    }
}
