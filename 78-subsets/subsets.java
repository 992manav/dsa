class Solution {
    List<List<Integer>> final_list = new ArrayList<>();

    void fun(List<Integer> lst, int[] nums, int starting_index) {
        final_list.add(new ArrayList<>(lst));

        for (int i = starting_index; i < nums.length; i++) {
            lst.add(nums[i]);
            fun(lst, nums, i + 1);
            lst.remove(lst.size() - 1); // backtrack
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        fun(new ArrayList<>(), nums, 0);
        return final_list;
    }
}
