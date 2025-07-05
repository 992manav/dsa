class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001]; // for range [-10000, 10000]
        Arrays.fill(count, 0);

        int max_index = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] + 10000;
            count[idx] += 1;

            if (idx > max_index) {
                max_index = idx;
            }
        }

        for (int i = max_index; i >= 0; i--) {
            k -= count[i];
            if (k <= 0) {
                return i - 10000; 
            }
        }

        return -1;
    }
}
