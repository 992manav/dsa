import java.util.Arrays;

class Solution {
    int[][] dp;

    int fun(int[] nums, int index, boolean flag) {
        if (index >= nums.length) return 0;

        int f = flag ? 1 : 0;
        if (dp[index][f] != -1) return dp[index][f];

        int skip, take;

        if (index == 0) {
            skip = fun(nums, index + 1, false);
            take = nums[index] + fun(nums, index + 2, true);
            return dp[index][f] = Math.max(skip, take);
        } 
        else if (index == nums.length - 1) {
            if (flag) {
                skip = fun(nums, index + 1, true);
                take = Integer.MIN_VALUE;
            } else {
                skip = fun(nums, index + 1, false);
                take = nums[index] + fun(nums, index + 2, false);
            }
            return dp[index][f] = Math.max(skip, take);
        } 
        else {
            if (flag) {
                skip = fun(nums, index + 1, true);
                take = nums[index] + fun(nums, index + 2, true);
            } else {
                skip = fun(nums, index + 1, false);
                take = nums[index] + fun(nums, index + 2, false);
            }
        }
        return dp[index][f] = Math.max(skip, take);
    }

    public int rob(int[] nums) {
        dp = new int[nums.length][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return fun(nums, 0, false);
    }
}
