class Solution {

    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        long ans = Long.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long lc = find_cost(nums, cost, mid - 1);
            long cur = find_cost(nums, cost, mid);
            long rc = find_cost(nums, cost, mid + 1);

            long min = Math.min(lc, rc);
            ans = Math.min(ans, Math.min(cur, min));

            if (rc > cur) {
                if (lc > cur) {
                    if (lc < rc) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public long find_cost(int[] nums, int[] cost, int target) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += 1L * Math.abs(nums[i] - target) * cost[i];
        }
        return res;
    }
}
