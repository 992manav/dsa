class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int a = nums[n - 1] + nums[n - 2] - nums[0];
        int b = nums[0] + nums[1] - nums[n - 1];

        if (a > b) {
            return a;
        }
        return b;
    }
}
