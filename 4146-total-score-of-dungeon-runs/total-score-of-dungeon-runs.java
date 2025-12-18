class Solution {

    int binary_search(int[] prefix_d, int hp, int tot_demand_sum, int r, int max_i) {
        int low = 0;
        int high = max_i - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int damage;
            if (mid == 0) {
                damage = tot_demand_sum;
            } else {
                damage = tot_demand_sum - prefix_d[mid - 1];
            }

            if (hp - damage >= r) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public long totalScore(int hp, int[] d, int[] req) {
        int n = d.length;
        long tot = 0;

        int[] prefix_d = new int[n];
        prefix_d[0] = d[0];

        for (int i = 1; i < n; i++) {
            prefix_d[i] = prefix_d[i - 1] + d[i];
        }

        for (int i = 0; i < n; i++) {
            int r = req[i];
            int tot_demand_sum = prefix_d[i];

            int count = 0;

            // handle start = i separately
            if (hp - d[i] >= r) {
                count = 1;
            }

            // binary search for starts in [0 ... i-1]
            if (i > 0) {
                int index = binary_search(prefix_d, hp, tot_demand_sum, r, i);
                if (index != -1) {
                    count += (i - index);
                }
            }

            tot += count;
        }

        return tot;
    }
}
