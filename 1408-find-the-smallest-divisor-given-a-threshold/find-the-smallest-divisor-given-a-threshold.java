class Solution {

    // Helper method to calculate the sum of ceiling values of nums[i]/x
    int calculate_sum(int[] nums, int x,int target) {
        int sum = 0;

        for (int num : nums) {
            // Use Math.ceil to round up the division result
            sum = sum + (int) Math.ceil((double) num / x);
            if (sum > target) {
                    break;
            }
        }
        return sum;
    }

    // Helper method to find the maximum value in the array
    int find_max(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    // Binary search to find the smallest divisor such that
    // the sum of ceil(nums[i]/divisor) is less than or equal to the target
    int binary_search(int[] nums, int target) {

        int low = 1; // minimum possible divisor
        int high = find_max(nums); // maximum possible divisor
        int ans = 0; // variable to store the answer
        int mid = 0; 
        int max_sum = Integer.MIN_VALUE; // to keep track of the best possible valid sum

        while (low <= high) {
            mid = (low + high) / 2; // choose middle value as current divisor candidate
            int sum = calculate_sum(nums, mid,target); // calculate sum for this divisor

            if (sum <= target) {
                // update answer if the sum is valid and better than previous best
                if (sum >= max_sum) {
                    if (sum == max_sum) {
                        if (mid < ans) {
                            ans = mid; // choose smaller divisor if same sum
                        }
                    } else {
                        max_sum = sum;
                        ans = mid;
                    }
                }
                high = mid - 1; // try to find a smaller divisor
            } else {
                low = mid + 1; // try to find a bigger divisor to reduce the sum
            }

        }
        return ans; // return the smallest divisor found
    }

    // Main method to find the smallest divisor that meets the threshold condition
    public int smallestDivisor(int[] nums, int threshold) {
        return binary_search(nums, threshold);
    }
}
