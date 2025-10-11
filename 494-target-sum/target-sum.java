class Solution {

    int len;
    int target;
    int[] nums;
    int[][] dp;
    
    int fun(int i, int sum, int total) {
        if (i >= len) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + total] != -1) {  
            return dp[i][sum + total];
        }

        int plus = fun(i + 1, sum + nums[i], total);
        int sub = fun(i + 1, sum - nums[i], total);

        dp[i][sum + total] = plus + sub;
        return dp[i][sum + total];
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.len = nums.length;
        
      
        int total = 0;
        for (int num : nums) total += num;
        
    
        dp = new int[len][2 * total + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return fun(0, 0, total);
    }
}
