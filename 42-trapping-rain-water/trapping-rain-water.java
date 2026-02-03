class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] prefix_max = new int[n];
        prefix_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix_max[i] = Math.max(height[i], prefix_max[i - 1]);
        }

        int[] suffix_max = new int[n];
        suffix_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix_max[i] = Math.max(height[i], suffix_max[i + 1]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(prefix_max[i], suffix_max[i]);
            count += min - height[i];
        }

        return count;
    }
}
