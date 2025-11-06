class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            prefix[start] += 1;
            if (end + 1 < n) prefix[end + 1] -= 1;
        }

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (nums[i] > prefix[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
