class Solution {
    int[] nums;
    Boolean[][] dp;
    int totalSum;

    boolean fun(int sum1, int index) {
        int sum2 = totalSum - sum1;
        if (index == nums.length) return sum1 == sum2;
        if (dp[sum1][index] != null) return dp[sum1][index];
        boolean one = fun(sum1 + nums[index], index + 1);
        boolean two = fun(sum1, index + 1);
        dp[sum1][index] = one || two;
        return dp[sum1][index];
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        dp = new Boolean[totalSum + 1][nums.length + 1];
        return fun(0, 0);
    }
}
