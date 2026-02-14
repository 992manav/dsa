import java.util.*;

class Solution {
    long[] dp;
    int n;
    int[] colors;
    int[] nums;

    long fun(int i){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        long skip = fun(i + 1);

        long take = nums[i];

        if(i + 1 < n && colors[i] == colors[i + 1]){
            take += fun(i + 2);
        } else {
            take += fun(i + 1);
        }

        return dp[i] = Math.max(skip, take);
    }

    public long rob(int[] nums, int[] colors) {
        n = nums.length;
        this.colors = colors;
        this.nums = nums;

        dp = new long[n];
        Arrays.fill(dp, -1);

        return fun(0);
    }
}
