class Solution {

    int[] nums;
    Boolean[][] dp;
    int totalSum;
    int target;

    boolean fun(int sum1, int index) {
        if (sum1 > target) return false;

        if (index == nums.length) return sum1 == (totalSum - sum1);

        if (dp[sum1][index] != null) return dp[sum1][index];

        // Early return: agar sum1 branch true hai to sum2 branch skip
        if (fun(sum1 + nums[index], index + 1)) {
            dp[sum1][index] = true;
            return true;
        }

        dp[sum1][index] = fun(sum1, index + 1);
        return dp[sum1][index];
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;

        totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum % 2 != 0) return false;

        target = totalSum / 2;
        dp = new Boolean[target + 1][nums.length]; // last column can be nums.length-1

        return fun(0, 0);
    }
}
