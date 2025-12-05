class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int[] prefix_sum = new int[n];
        prefix_sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }

        int[] suffix_sum = new int[n];
        suffix_sum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix_sum[i] = suffix_sum[i + 1] + nums[i];
        }

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (i + 1 < n) {
                int diff = prefix_sum[i] - suffix_sum[i + 1];
                if (Math.abs(diff) % 2 == 0) {
                    count++;
                }
            }

            // if (i - 1 >= 0) {
            //     int diff1 = prefix_sum[i - 1] - suffix_sum[i];
            //     if (Math.abs(diff1) % 2 == 0) {
            //         count++;
            //     }
            // }
        }

        return count;
    }
}
