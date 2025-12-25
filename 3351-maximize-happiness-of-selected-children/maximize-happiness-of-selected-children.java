import java.util.*;

class Solution {

    public long maximumHappinessSum(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        long sum = 0;
        int start = n - 1;
        int minus = 0;

        while (k > 0 && start >= 0) {
            if (nums[start] - minus <= 0) {
                break;
            }

            sum += nums[start] - minus;
            start--;
            k--;
            minus++;
        }

        return sum;
    }
}
