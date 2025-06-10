import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), 0, finalList);
        return finalList;
    }

    private static void combinationSumHelper(int[] nums, int target, int start, 
                                          List<Integer> current, int sum, 
                                          List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (sum > target || start >= nums.length) {
            return;
        }

        // Include current number
        if(nums[start]+sum<=target){

        current.add(nums[start]);
        combinationSumHelper(nums, target, start + 1, current, sum + nums[start], result);
        current.remove(current.size() - 1);
        }
        // Skip duplicates
        while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
            start++;
        }
        
        // Exclude current number
        combinationSumHelper(nums, target, start + 1, current, sum, result);
    }
}