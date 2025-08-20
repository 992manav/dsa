import java.util.*;

class Pair {
    long prefixSum;
    int i;

    Pair(long prefixSum, int index) {
        this.prefixSum = prefixSum;
        this.i = index;
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int target) {
        Deque<Pair> dq = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        long prefixSum = 0;

        // base prefix sum before array starts
        dq.offerLast(new Pair(0, -1));

        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j];

            // check if current subarray is valid
            while (!dq.isEmpty() && prefixSum - dq.peekFirst().prefixSum >= target) {
                minLength = Math.min(minLength, j - dq.peekFirst().i);
                dq.pollFirst();
            }

            // maintain monotonic deque
            while (!dq.isEmpty() && dq.peekLast().prefixSum >= prefixSum) {
                dq.pollLast();
            }

            dq.offerLast(new Pair(prefixSum, j));
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
