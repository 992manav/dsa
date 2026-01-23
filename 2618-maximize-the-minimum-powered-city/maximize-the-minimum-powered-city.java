class Solution {

    int n;
    int r;

    boolean possiblehaikya(long min_pow, long[] pow, long k) {

        long[] diff = new long[n + 1];

        for (int i = 0; i < pow.length; i++) {

            if (i > 0) {
                diff[i] = diff[i - 1] + diff[i];
            }

            long cur_pow = pow[i] + diff[i];

            if (cur_pow < min_pow) {

                long kitnaadd = min_pow - cur_pow;

                if (kitnaadd <= k) {
                    k = k - kitnaadd;
                } else {
                    return false;
                }

                int right = Math.min(i + r, n - 1);
                int right_r = Math.min(i + 2 * r, n - 1);

                diff[i] += kitnaadd;
                diff[right_r + 1] -= kitnaadd;
            }
        }

        return true;
    }

    public long maxPower(int[] nums, int r, int k) {

        this.n = nums.length;
        this.r = r;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long[] pow = new long[n];

        for (int i = 0; i < n; i++) {

            int right = Math.min(i + r, n - 1);
            int left = Math.max(0, i - r);

            if (left == 0) {
                pow[i] = prefix[right];
            } else {
                pow[i] = prefix[right] - prefix[left - 1];
            }
        }

        long low = Long.MAX_VALUE;
        long high = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, pow[i]);
            high = Math.max(high, pow[i]);
        }

        high = high + k;
        long ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (possiblehaikya(mid, pow, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
