class Solution {
    int[] dp;

    int fun(int[] nums, int index) {
        if (index >= nums.length) return 0;

        if (dp[index] != -1) return dp[index];

        // Choice 1: skip current house
        int skip = fun(nums, index + 1);

        // Choice 2: take current house
        int take = nums[index] + fun(nums, index + 2);

        // Store max in dp and return
        return dp[index] = Math.max(skip, take);
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1); // Initialize all with -1

        return fun(nums, 0); // Start from index 0
    }
}
