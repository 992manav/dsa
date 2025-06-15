class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        // Special case: m == 1
        if (m == 1) {
            for (int num : nums) {
                ans = Math.max(ans, (long) num * num);
            }
            return ans;
        }

        // Suffix arrays to store max and min from i to n-1
        int[] maxSuffix = new int[n];
        int[] minSuffix = new int[n];

        maxSuffix[n - 1] = nums[n - 1];
        minSuffix[n - 1] = nums[n - 1];

        // Build max and min suffix arrays
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(nums[i], maxSuffix[i + 1]);
            minSuffix[i] = Math.min(nums[i], minSuffix[i + 1]);
        }

        // Iterate over valid starting points for subsequence of length m
        for (int i = 0; i <= n - m; i++) {
            int j = i + m - 1; // last element of subsequence
            long prod1 = (long) nums[i] * maxSuffix[j];
            long prod2 = (long) nums[i] * minSuffix[j];
            ans = Math.max(ans, Math.max(prod1, prod2));
        }

        return ans;
    }
}
