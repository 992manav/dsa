class Solution {
    List<List<Integer>> final_list = new ArrayList<>();

    void backtrack(int[] nums, int index, List<Integer> current) {
        final_list.add(new ArrayList<>(current)); // ✅ Add a copy of the current subset

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);          // Choose
            backtrack(nums, i + 1, current); // Explore
            current.remove(current.size() - 1); // Un-choose (backtrack)
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return final_list;
    }
}
