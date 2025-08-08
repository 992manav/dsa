import java.util.Arrays;

class Solution {
    int[] dp1;
    int[] dp2;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        dp1 = new int[n];
        dp2 = new int[n];

        // Case 1: rob from 0 to n-2 (exclude last)
        dp1[n - 1] = 0; 
        dp1[n - 2] = nums[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp1[i] = Math.max(nums[i] + dp1[i + 2], dp1[i + 1]);
        }
        int max1 = dp1[0];

        // Case 2: rob from 1 to n-1 (exclude first)
        dp2[n - 1] = nums[n - 1];
        dp2[n - 2] = Math.max(nums[n - 2], nums[n - 1]);
        for (int i = n - 3; i >= 1; i--) {
            dp2[i] = Math.max(nums[i] + dp2[i + 2], dp2[i + 1]);
        }
        int max2 = dp2[1];

        return Math.max(max1, max2);
    }
}
