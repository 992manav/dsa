import java.util.*;

class Solution {

    // aa function same value ni last index sudhi pointer ne aagad lai jaay
    int moveSame(int[] nums, int idx, int n) {
        while (idx + 1 < n && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        return idx;
    }

    public int unequalTriplets(int[] nums) {

        // pehla sort kariye taaki same numbers ek jagae aavi jaay
        Arrays.sort(nums);
        int n = nums.length;

        int prev = 0;     // left group ni last index
        int curr;         // middle group ni last index
        int front;        // right group ni starting index
        int count = 0;    // answer

        // first group (left) complete karo
        prev = moveSame(nums, prev, n);

        // second group (middle) start
        curr = prev + 1;
        if (curr >= n) return 0;

        // middle group complete karo
        curr = moveSame(nums, curr, n);

        // third group (right) start
        front = curr + 1;

        // badha distinct middle groups mate count calculate karo
        while (front < n) {

            // left side ma ketla elements
            int left = prev + 1;

            // middle group ma ketla elements
            int mid = curr - prev;

            // right side ma ketla elements
            int right = n - front;

            // unequal triplets = left * mid * right
            count += left * mid * right;

            // middle ne left banaavi do
            prev = curr;

            // next distinct value mate middle move karo
            front = moveSame(nums, front, n);
            curr = front;
            front++;
        }

        return count;
    }
}
