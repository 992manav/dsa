import java.util.*;

class Solution {
    public int longestIdealString(String s, int k) {
        char[] nums = s.toCharArray();
        int[] max_dp = new int[26];

        int len = 1;

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 'a';

            int cur = 1;   // FIX: always start fresh for this character

            for (int diff = 0; diff <= k; diff++) {

                if (index - diff >= 0) {
                    cur = Math.max(cur, max_dp[index - diff] + 1);
                }

                if (diff != 0 && index + diff < 26) {  
                    cur = Math.max(cur, max_dp[index + diff] + 1);
                }
            }

            max_dp[index] = Math.max(max_dp[index], cur);
            len = Math.max(len, max_dp[index]);
        }

        return len;
    }
}
