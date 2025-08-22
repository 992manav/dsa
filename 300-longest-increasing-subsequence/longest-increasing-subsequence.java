import java.util.*;

class Solution {
    int[] nums;
    int[][] dp;

    int fun(int last_index, int index) {
        if (index >= nums.length) {
            return 0;
        }

        int li = last_index + 1;

        if (dp[index][li] != -1) {
            return dp[index][li];
        }

        int take = 0;
        if (last_index == -1 || nums[index] > nums[last_index]) {
            take = 1 + fun(index, index + 1);
        }

        int skip = fun(last_index, index + 1);

        dp[index][li] = Math.max(take, skip);
        return dp[index][li];
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n + 1]; 

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(-1, 0);
    }
}
