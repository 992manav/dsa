import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {

        /*
         Voting (Boyer–Moore style) idea:
         --------------------------------
         - We keep a candidate element (ele) and a counter (count).
         - When we see the same element as the candidate, we increase the count.
         - When we see a different element, we decrease the count.
         - This simulates "cancelling out" different elements against each other.
         - If an element is repeated many times, it survives these cancellations.
        */

        int count = 0;     // Tracks the current vote balance
        int ele = -1;      // Current candidate element

        // This set stores all elements that could potentially be the repeated one
        // (elements seen at cancellation points or final candidate)
        Set<Integer> set = new HashSet<>();

        // First pass: apply voting and collect possible candidates
        for (int i = 0; i < nums.length; i++) {

            // If no active candidate, pick the current element
            if (count == 0) {
                ele = nums[i];
                count = 1;

            // Same as candidate → reinforce the vote
            } else if (nums[i] == ele) {
                count++;

            // Different from candidate → cancel one vote
            } else {
                count--;
            }

            /*
             When count becomes zero:
             - It means the current candidate has been completely cancelled
               by different elements.
             - The current element that caused this cancellation may be part
               of the repeated element.
             - So we store nums[i] as a possible candidate.
            */
            if (count == 0) {
                set.add(nums[i]);
            }
        }

        /*
         The final candidate 'ele' might still be the repeated element,
         so we add it to the set of possible answers.
        */
        set.add(ele);

        /*
         Second pass (verification):
         ---------------------------
         - Voting only gives possible candidates.
         - Since the repeated element appears exactly n/2 times (not more),
           we must verify the actual frequency.
        */
        for (Integer x : set) {
            count = 0;

            // Count how many times x appears
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == x) {
                    count++;
                }
            }

            // The correct element appears exactly n/2 times
            if (count == nums.length / 2) {
                return x;
            }
        }

        // Guaranteed not to happen due to problem constraints
        return -1;
    }
}
