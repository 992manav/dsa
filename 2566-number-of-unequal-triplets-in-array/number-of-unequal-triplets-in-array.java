import java.util.*;

class Solution {
    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int prev = 0;
        int curr = 0;
        int front = 0;
        int count = 0;

        while (prev + 1 < n && nums[prev] == nums[prev + 1]) {
            prev++;
        }

        curr = prev + 1;
        if (curr >= n) return 0;

        while (curr + 1 < n && nums[curr] == nums[curr + 1]) {
            curr++;
        }

        front = curr + 1;

        while (front < n) {
            int left = prev + 1;
            int mid = curr - prev;
            int right = n - front;

            count += left * mid * right;

            prev = curr;

            while (front + 1 < n && nums[front] == nums[front + 1]) {
                front++;
            }

            curr = front;
            front++;
        }

        return count;
    }
}
