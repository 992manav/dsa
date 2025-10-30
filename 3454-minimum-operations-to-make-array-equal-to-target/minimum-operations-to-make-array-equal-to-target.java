class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        
        long ops = 0; // should be long, since return type is long
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = target[i] - nums[i];

            if (diff < 0) {
                if (prev > 0) {
                    prev = 0;
                }

                if (diff < prev) {
                    ops += prev - diff;
                }
                prev = diff;
            } else {
                if (prev < 0) {
                    prev = 0;
                }

                if (diff > prev) {
                    ops += diff - prev;
                }
                prev = diff;
            }
        }

        return ops; // missing return
    }
}
