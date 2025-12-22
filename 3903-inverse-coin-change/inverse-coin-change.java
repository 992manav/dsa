import java.util.*;

class Solution {

    int[][][] dp;

    int fun(int index, int len, int target, List<Integer> nums) {

        if (target < 0) {
            return -1;
        }

        if (index == len) {
            if (target == 0) {
                return 1;
            }
            return -1;
        }

        if (dp[index][target][len] != -2) {
            return dp[index][target][len];
        }

        int val = nums.get(index);
        int maxTake = target / val;
        int count = 0;

        for (int i = 0; i <= maxTake; i++) {
            int res = fun(index + 1, len, target - val * i, nums);
            if (res != -1) {
                count += res;
            }
        }

        if (count == 0) {
            dp[index][target][len] = -1;
        } else {
            dp[index][target][len] = count;
        }

        return dp[index][target][len];
    }

    int findcombi(int target, List<Integer> nums) {

        if (nums.size() == 0) {
            return 0;
        }

        int len = nums.size();

        for (int i = 0; i <= len; i++) {
            for (int t = 0; t <= target; t++) {
                dp[i][t][len] = -2;
            }
        }

        int res = fun(0, len, target, nums);
        if (res == -1) {
            return 0;
        }
        return res;
    }

    public List<Integer> findCoins(int[] numWays) {

        int n = numWays.length + 2;
        dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }

        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < numWays.length; i++) {

            int target = i + 1;

            if (numWays[i] == 0) {
                if (!lst.isEmpty()) {
                    int c = findcombi(target, lst);
                    if (c != 0) {
                        return new ArrayList<>();
                    }
                }
                continue;
            }

            int c = findcombi(target, lst);

            if (c == numWays[i]) {
                continue;
            }

            if (c + 1 == numWays[i]) {
                lst.add(target);
            } else {
                return new ArrayList<>();
            }
        }

        return lst;
    }
}
