class Solution {

    int calculate_sum(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / x);
        }
        return sum;
    }

    int find_max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    int binary_search(int[] nums, int target) {
        int low = 1;
        int high = find_max(nums);
        int ans = high; // assume worst case (largest divisor)

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = calculate_sum(nums, mid);

            if (sum <= target) {
                ans = mid;         // valid divisor
                high = mid - 1;    // try to find smaller one
            } else {
                low = mid + 1;     // need larger divisor
            }
        }

        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        return binary_search(nums, threshold);
    }
}
