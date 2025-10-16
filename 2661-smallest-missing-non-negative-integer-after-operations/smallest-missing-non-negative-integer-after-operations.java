class Solution {

    int k;
    int[] nums;

    int replace(int num) {
        int pos = num;
        if (num < 0) {
            pos = Math.abs(num);
            int r = pos % k;
            if (r == 0) {
                return 0;
            }
            return k - r;
        } else {
            int r = pos % k;
            if (r == 0) {
                return 0;
            }
            return r;
        }
    }

    public int findSmallestInteger(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int n = nums.length;

        int[] freq = new int[k]; // only track remainders modulo k

        for (int i = 0; i < n; i++) {
            int curr = replace(nums[i]);
            curr = ((curr % k) + k) % k; // ensure 0 <= curr < k
            freq[curr]++;
        }

        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i < k; i++) {
            if (freq[i] == 0) {
                return i; // if a remainder never appears, that remainder itself is missing
            }
            if (freq[i] < min) {
                min = freq[i];
                min_index = i;
            }
        }

        return min * k + min_index; // correct formula for smallest missing number
    }
}
