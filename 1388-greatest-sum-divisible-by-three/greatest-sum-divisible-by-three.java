class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int sum = 0;

        int r1 = Integer.MAX_VALUE;
        int r11 = Integer.MAX_VALUE;

        int r2 = Integer.MAX_VALUE;
        int r22 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int r = nums[i] % 3;

            if (r == 1) {
                if (nums[i] < r1) {
                    r11 = r1;
                    r1 = nums[i];
                } else {
                    if (nums[i] < r11) {
                        r11 = nums[i];
                    }
                }
            }

            if (r == 2) {
                if (nums[i] < r2) {
                    r22 = r2;
                    r2 = nums[i];
                } else {
                    if (nums[i] < r22) {
                        r22 = nums[i];
                    }
                }
            }
        }

        if (sum % 3 == 0) return sum;

        int ans = 0;

        if (sum % 3 == 1) {
            int a = 0;
            int b = 0;
            if (r1 != Integer.MAX_VALUE) a = sum - r1;
            if (r2 != Integer.MAX_VALUE && r22 != Integer.MAX_VALUE) b = sum - (r2 + r22);
            if (a > b) ans = a;
            else ans = b;
            return ans;
        }

        int a = 0;
        int b = 0;
        if (r2 != Integer.MAX_VALUE) a = sum - r2;
        if (r1 != Integer.MAX_VALUE && r11 != Integer.MAX_VALUE) b = sum - (r1 + r11);
        if (a > b) ans = a;
        else ans = b;

        return ans;
    }
}
