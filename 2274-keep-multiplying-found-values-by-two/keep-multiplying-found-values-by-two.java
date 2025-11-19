class Solution {

    public int findFinalValue(int[] nums, int ori) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ori) {
                ori = ori * 2;
            }
        }

        return ori;
    }
}
