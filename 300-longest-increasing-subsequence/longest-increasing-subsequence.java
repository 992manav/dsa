import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] yahaanKhatamLIS = new int[nums.length];
        Arrays.fill(yahaanKhatamLIS, 1);

        int sabseBadaLength = 0;

        for (int abhiIndex = 0; abhiIndex < nums.length; abhiIndex++) {
            for (int pichlaIndex = 0; pichlaIndex < abhiIndex; pichlaIndex++) {
                if (nums[pichlaIndex] < nums[abhiIndex]) {
                    yahaanKhatamLIS[abhiIndex] =
                        Math.max(yahaanKhatamLIS[abhiIndex], yahaanKhatamLIS[pichlaIndex] + 1);
                }
            }
            sabseBadaLength = Math.max(sabseBadaLength, yahaanKhatamLIS[abhiIndex]);
        }

        return sabseBadaLength;
    }
}
