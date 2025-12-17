import java.util.*;

class Solution {

    int moveSame(int[] nums, int idx, int n) {
        while (idx + 1 < n && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        return idx;
    }

    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int prev = 0;
        int curr = 0;
        int front = 0;
        int count = 0;

        prev = moveSame(nums, prev, n);

        curr = prev + 1;
        if (curr >= n) return 0;

        curr = moveSame(nums, curr, n);
        front = curr + 1;

        while (front < n) {
            int left = prev + 1;
            int mid = curr - prev;
            int right = n - front;

            count += left * mid * right;

            prev = curr;

            front = moveSame(nums, front, n);
            curr = front;
            front++;
        }

        return count;
    }
}
