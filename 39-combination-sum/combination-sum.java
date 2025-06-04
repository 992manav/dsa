import java.util.*;

class Solution {

    int target;
    List <List<Integer>> final_list = new ArrayList<>();

    public void fun(List<Integer> lst, int sum, int[] nums, int starting_index) {

        // Prune branch early
        if (sum > target || starting_index >= nums.length) {
            return;
        }

        if (sum == target) {
            final_list.add(new ArrayList<>(lst));
            return;
        }

        // Include current number and recurse
        
        if (nums[starting_index] + sum <= target) {
            lst.add(nums[starting_index]);
            fun(lst, sum + nums[starting_index], nums, starting_index);         // Choose again
            // fun(lst, sum + nums[starting_index], nums, starting_index + 1);     // Choose and move forward
            lst.remove(lst.size() - 1); // Backtrack
        }

        // Exclude current number and move forward
        fun(lst, sum, nums, starting_index + 1);
    }

    public List<List<Integer>> combinationSum(int[] num, int tar) {
        this.target = tar;

        // Optional: sort to enable faster pruning or cleaner output
        // Arrays.sort(num);

        fun(new ArrayList<>(), 0, num, 0);
        return final_list;
    }
}
