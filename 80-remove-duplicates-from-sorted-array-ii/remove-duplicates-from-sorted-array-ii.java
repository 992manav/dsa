import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int length = nums.length;
        while (j < length) {
            if (j < length - 1 && nums[j] != Integer.MAX_VALUE && nums[j + 1] != Integer.MAX_VALUE && nums[j] == nums[j + 1]) {
                if (i < length) nums[i] = nums[j];
                if (i + 1 < length) nums[i + 1] = nums[j + 1];
                if (i != j) {
                    if (j > i + 1 && j < length) nums[j] = Integer.MAX_VALUE;  // Only mark if j is beyond i+1
                    if (j + 1 > i + 1 && j + 1 < length) nums[j + 1] = Integer.MAX_VALUE;  // Only mark if j+1 is beyond i+1
                }
                i = i + 2;
                j = j + 2;
                while (j < length && (nums[j] == nums[i - 1] || nums[j] == Integer.MAX_VALUE)) {
                    j++;
                }
            } else {
                if (nums[j] != Integer.MAX_VALUE) {
                    nums[i] = nums[j];
                    i++;
                }
                if (i - 1 != j && j > i - 1 && j < length) {  // Only mark if j is beyond where we wrote
                    nums[j] = Integer.MAX_VALUE;
                }
                j++;
            }
        }
        return i;
    }
}