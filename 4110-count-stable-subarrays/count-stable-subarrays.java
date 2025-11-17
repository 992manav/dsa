import java.util.*;

class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = 1;
            }
        }

        long[] cum_sum = new long[n];
        cum_sum[0] = prefix[0];
        for (int i = 1; i < n; i++) cum_sum[i] = cum_sum[i - 1] + prefix[i];

        int[] find = new int[n];
        int last = n - 1;
        find[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) last = i;
            find[i] = last;
        }

        long[] ans = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = prefix[l] - 1;

            int rr = find[l];
            if (rr >= r) rr = r;

            int count = rr - l + 1;

            long base = cum_sum[rr] - (l == 0 ? 0 : cum_sum[l - 1]);
            long sum = base - (long) count * left;

            if (rr < r) sum += cum_sum[r] - cum_sum[rr];

            ans[i] = sum;
        }

        return ans;
    }
}
