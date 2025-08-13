import java.util.*;

class Solution {

    int rev(int n) {
        int ans = 0;
        while (n != 0) {
            ans = ans * 10 + n % 10;
            n = n / 10;
        }
        return ans;
    }

    public int countNicePairs(int[] nums) {
        int MOD = 1_000_000_007;
        long count = 0;

        int[] diffArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diffArr[i] = nums[i] - rev(nums[i]); // store nums[i] - rev(nums[i])
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(diffArr[i], map.getOrDefault(diffArr[i], 0) + 1);
        }

        for (int value : map.values()) {
            if (value > 1) {
                count += ((long) value * (value - 1)) / 2; // nC2 formula
            }
        }

        return (int) (count % MOD);
    }
}
