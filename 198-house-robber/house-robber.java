import java.util.Arrays;

class Solution {
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 2], dp[n - 1]);

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
