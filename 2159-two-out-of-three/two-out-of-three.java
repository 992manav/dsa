import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] mask = new int[101]; // store bitmask for each number
        List<Integer> result = new ArrayList<>();

        // Mark presence in nums1 (bit 0)
        for (int num : nums1) {
            mask[num] |= 1; // set bit 0
        }
        // Mark presence in nums2 (bit 1)
        for (int num : nums2) {
            mask[num] |= 2; // set bit 1
        }
        // Mark presence in nums3 (bit 2)
        for (int num : nums3) {
            mask[num] |= 4; // set bit 2
        }

        // Collect numbers that appear in at least 2 arrays
        for (int i = 1; i <= 100; i++) {
            // Count bits set in mask[i]
            if (Integer.bitCount(mask[i]) >= 2) {
                result.add(i);
            }
        }
        return result;
    }
}
