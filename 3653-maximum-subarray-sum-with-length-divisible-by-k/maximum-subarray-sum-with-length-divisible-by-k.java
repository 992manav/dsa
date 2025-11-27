class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            long min = Long.MAX_VALUE;

            for (int j = i; j < n; j += k) {

                if (min != Long.MAX_VALUE) {
                    long sum = prefix[j] - min;
                    if (sum > ans) ans = sum;
                }

                if (i == k - 1) {
                    long sum = prefix[j];
                    if (sum > ans) ans = sum;
                }

                if (prefix[j] < min) min = prefix[j];
            }
        }

        return ans;
    }
}
