import java.util.*;
class Solution {
    int target;
    Set<List<Integer>> final_list = new HashSet<>();
    public void fun(List<Integer> lst, int sum, int[] nums, int starting_index) {
        if (sum == target) {
            List<Integer> copy = new ArrayList<>(lst);
            // Collections.sort(copy);
            final_list.add(copy);
            return;
        }
        if ( sum>target || starting_index >= nums.length) {
            return;
        }
        // Include current number and recurse
        if (nums[starting_index] + sum <= target) {
            lst.add(nums[starting_index]);
            fun(lst, sum + nums[starting_index], nums, starting_index + 1); // Choose and move forward
            lst.remove(lst.size() - 1); // Backtrack
        }
        while(starting_index + 1 < nums.length && nums[starting_index+1]==nums[starting_index]){
            starting_index++;
        }
        fun(lst, sum, nums, starting_index + 1); // Skip current number
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int tar) {
        this.target = tar;
        Arrays.sort(candidates); 
        fun(new ArrayList<>(), 0, candidates, 0);
        return new ArrayList<>(final_list);
    }
}
