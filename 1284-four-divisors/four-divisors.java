class Solution {
    public int sumFourDivisors(int[] nums) {

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }

        int[] fac = new int[max + 1];
        int[] fac_freq = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                fac[j] += i;
                fac_freq[j]++;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (fac_freq[nums[i]] == 4) {
                sum += fac[nums[i]];
            }
        }

        return sum;
    }
}
