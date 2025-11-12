class Solution {

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int g = nums[0];

        for (int i = 1; i < n; i++) {
            g = gcd(g, nums[i]);
        }

        if (g != 1) return -1;

        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }

        if (ones > 0) {
            // only need to convert remaining numbers to 1
            return n - ones;
        }

        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minOps = Math.min(minOps, j - i);
                    break;
                }
            }
        }

        return minOps + n - 1;
    }
}
