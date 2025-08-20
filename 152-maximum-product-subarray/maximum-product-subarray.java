class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int max = Integer.MIN_VALUE;
        int min_neg_value = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                min_neg_value = Integer.MAX_VALUE;
                max = Math.max(0, max);
                prefixProduct = 1;
            } else {
                prefixProduct = prefixProduct * nums[i];
                if (prefixProduct < 0) {
                    if (min_neg_value != Integer.MAX_VALUE) {
                        max = Math.max(max, prefixProduct / min_neg_value);
                    }
                    if (Math.abs(prefixProduct) < Math.abs(min_neg_value)) {
                        min_neg_value = prefixProduct;
                    }
                }
                max = Math.max(prefixProduct, max);
            }
        }
        return max;
    }
}
