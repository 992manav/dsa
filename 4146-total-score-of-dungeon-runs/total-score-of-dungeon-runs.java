class Solution {

    // Binary search to find the earliest index `mid` (0 to max_i)
    // such that after taking damage from rooms [mid .. i],
    // remaining hp is still >= r
    int binary_search(int[] prefix_d, int hp, int tot_demand_sum, int r, int max_i) {

        int low = 0;
        int high = max_i;
        int ans = -1;   // stores the leftmost valid index

        while (low <= high) {

            // standard mid calculation
            int mid = low + (high - low) / 2;

            int damage;

            // if mid == 0, no prefix is excluded
            // so full damage till i is applied
            if (mid == 0) {
                damage = tot_demand_sum;
            } 
            // otherwise subtract damage of rooms [0 .. mid-1]
            // remaining damage is from [mid .. i]
            else {
                damage = tot_demand_sum - prefix_d[mid - 1];
            }

            // check if after damage, hp is still enough
            if (hp - damage >= r) {
                ans = mid;        // valid index found
                high = mid - 1;   // try to find an even smaller index
            } else {
                low = mid + 1;    // need to start later
            }
        }

        return ans;
    }

    public long totalScore(int hp, int[] d, int[] req) {

        int n = d.length;
        long tot = 0;

        // prefix_d[i] = total damage from room 0 to i
        int[] prefix_d = new int[n];
        prefix_d[0] = d[0];

        for (int i = 1; i < n; i++) {
            prefix_d[i] = prefix_d[i - 1] + d[i];
        }

        // try every starting room i
        for (int i = 0; i < n; i++) {

            int r = req[i];                  // requirement at room i
            int tot_demand_sum = prefix_d[i]; // total damage till i

            // find earliest starting index that can still clear room i
            int index = binary_search(prefix_d, hp, tot_demand_sum, r, i);

            // if such index exists, all starts from [index .. i] are valid
            if (index != -1) {
                tot += (i - index + 1);
            }
        }

        return tot;
    }
}
