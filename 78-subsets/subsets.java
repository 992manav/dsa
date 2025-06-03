class Solution {
    List<List<Integer>> final_list = new ArrayList<>();

    void backtrack(int[] nums, int index, List<Integer> current) {
        // ✅ Add a copy of the current subset
        if (index >= nums.length) {
            final_list.add(new ArrayList<>(current)); 
            return; // Important to stop further execution when base case hits
        }

        current.add(nums[index]); // Choose
        backtrack(nums, index + 1, current); // Explore
        current.remove(current.size() - 1); // Un-choose (backtrack)

        backtrack(nums, index + 1, current); // Skip current element
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return final_list;
    }
}
