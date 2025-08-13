class Solution {

    int[] nums;
    int[][] dp;

    int fun(int index, int lastIndex) {
        if (index >= nums.length) return 0;

        if (dp[index][lastIndex + 1] != -1) return dp[index][lastIndex + 1];

        int ans = 0;
        if (lastIndex == -1 || nums[index] > nums[lastIndex]) {
            ans = 1 + fun(index + 1, index);
        }

        ans = Math.max(ans, fun(index + 1, lastIndex));

        return dp[index][lastIndex + 1] = ans;
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return fun(0, -1);
    }
}
