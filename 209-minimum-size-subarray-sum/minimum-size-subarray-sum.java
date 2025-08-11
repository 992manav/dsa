class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE; // fixed typo

        while (j < nums.length) {
            sum += nums[j];

            while (sum >= target) { // use while to shrink window as much as possible
                min = Math.min(min, j - i + 1); // fixed: compare length, not sum
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
