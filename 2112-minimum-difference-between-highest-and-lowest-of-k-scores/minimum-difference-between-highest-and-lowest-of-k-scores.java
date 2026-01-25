class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;

        for (int i = k - 1; i < n; i++) {
            min_diff = Math.min(min_diff, nums[i] - nums[i - k + 1]);
        }

        return min_diff;
    }
}
