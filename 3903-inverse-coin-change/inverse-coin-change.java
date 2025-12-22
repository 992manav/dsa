import java.util.*;

class Solution {

    int[][] dp;

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

        if (dp[index][target] != -2) {
            return dp[index][target];
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

        dp[index][target] = (count == 0) ? -1 : count;
        return dp[index][target];
    }

    int findcombi(int target, List<Integer> nums) {

        if (nums.size() == 0) {
            return 0;
        }

        int res = fun(0, nums.size(), target, nums);
        return res == -1 ? 0 : res;
    }

    public List<Integer> findCoins(int[] numWays) {

        int maxN = numWays.length + 2;
        dp = new int[maxN][maxN];

        for (int i = 0; i < maxN; i++) {
            Arrays.fill(dp[i], -2);
        }

        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < numWays.length; i++) {

            if (numWays[i] == 0) {
                if (!lst.isEmpty()) {
                    int c = findcombi(i + 1, lst);
                    if (c != 0) {
                        return new ArrayList<>();
                    }
                }
                continue;
            }

            int c = findcombi(i + 1, lst);

            if (c == numWays[i]) {
                continue;
            }

            if (c + 1 == numWays[i]) {
                lst.add(i + 1);

                for (int r = 0; r < maxN; r++) {
                    Arrays.fill(dp[r], -2);
                }

            } else {
                return new ArrayList<>();
            }
        }

        return lst;
    }
}
