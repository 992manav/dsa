class Solution {

    int len;
    int target;
    int[] nums;

    int fun(int i, int sum) {
        if (i >= len) {
            return sum == target ? 1 : 0;
        }

        int plus = fun(i + 1, sum + nums[i]);
        int sub = fun(i + 1, sum - nums[i]);

        return plus + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.len = nums.length;
        return fun(0, 0);
    }
}
