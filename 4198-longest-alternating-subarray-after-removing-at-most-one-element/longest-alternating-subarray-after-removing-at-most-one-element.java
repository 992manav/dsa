class Solution {
    public int longestAlternating(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                prefix[i] = 1;
            } else if (i == 1) {
                prefix[i] = 2;
            } else {
                if ((nums[i] > nums[i - 1] && nums[i - 1] < nums[i - 2]) ||
                    (nums[i] < nums[i - 1] && nums[i - 1] > nums[i - 2])) {
                    prefix[i] = prefix[i - 1] + 1;
                } else {
                    prefix[i] = 2;
                }
            }
        }

        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                suffix[i] = 1;
            } else if (i == n - 2) {
                suffix[i] = 2;
            } else {
                if ((nums[i] > nums[i + 1] && nums[i + 1] < nums[i + 2]) ||
                    (nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2])) {
                    suffix[i] = suffix[i + 1] + 1;
                } else {
                    suffix[i] = 2;
                }
            }
        }

        int max_len = 1;
        for (int i = 0; i < n; i++) {
            max_len = Math.max(max_len, prefix[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] == nums[i + 1]) continue;

            boolean canMerge = true;

            if (prefix[i - 1] >= 2) {
                boolean leftArriving = nums[i - 1] > nums[i - 2];
                boolean leftLeaving  = nums[i + 1] > nums[i - 1];
                if (leftArriving == leftLeaving) canMerge = false;
            }

            if (suffix[i + 1] >= 2) {
                boolean rightArriving = nums[i + 1] > nums[i - 1];
                boolean rightLeaving  = nums[i + 2] > nums[i + 1];
                if (rightArriving == rightLeaving) canMerge = false;
            }

            if (canMerge) {
                max_len = Math.max(max_len, prefix[i - 1] + suffix[i + 1]);
            } else {
                // Can only extend prefix by nums[i+1] if it alternates with end of prefix
                if (prefix[i - 1] == 1 ||
                    (nums[i + 1] > nums[i - 1] && nums[i - 1] < nums[i - 2]) ||
                    (nums[i + 1] < nums[i - 1] && nums[i - 1] > nums[i - 2])) {
                    max_len = Math.max(max_len, prefix[i - 1] + 1);
                }
                // Can only extend suffix by nums[i-1] if it alternates with start of suffix
                if (suffix[i + 1] == 1 ||
                    (nums[i - 1] > nums[i + 1] && nums[i + 1] < nums[i + 2]) ||
                    (nums[i - 1] < nums[i + 1] && nums[i + 1] > nums[i + 2])) {
                    max_len = Math.max(max_len, suffix[i + 1] + 1);
                }
            }
        }

        return max_len;
    }
}