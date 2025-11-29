import java.util.*;

class Solution {
    public int longestIdealString(String s, int k) {
        char[] nums = s.toCharArray();
        int[] max_dp = new int[26];  // aa array ma pratyek character nu best length store thai che

        int len = 1;  // overall max subsequence length

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 'a'; // current character ne index ma convert kariye

            int cur = 1;  // aa character thi navi subsequence sharu kari sakay

            for (int diff = 0; diff <= k; diff++) {

                // left side check kariye (nearby chars)
                if (index - diff >= 0) {
                    cur = Math.max(cur, max_dp[index - diff] + 1);  
                    // jo abs diff <= k hoy to subsequence extend thai shake
                }

                // right side check (diff != 0 etle self-add nai thai)
                if (diff != 0 && index + diff < 26) {  
                    cur = Math.max(cur, max_dp[index + diff] + 1);
                }
            }

            // current char mate best value update kariye
            max_dp[index] = Math.max(max_dp[index], cur);

            // overall longest update
            len = Math.max(len, max_dp[index]);
        }

        return len;  // final answer, longest ideal subsequence
    }
}
