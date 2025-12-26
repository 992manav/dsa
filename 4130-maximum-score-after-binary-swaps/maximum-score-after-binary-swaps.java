import java.util.*;

class Solution {
    public long maximumScore(int[] nums, String s) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            pq.offer(nums[i]);
            if (c == '1') {
                sum += pq.poll();
            }
        }

        return sum;
    }
}
