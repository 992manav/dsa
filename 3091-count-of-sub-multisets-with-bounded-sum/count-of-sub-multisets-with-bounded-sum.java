import java.util.*;

class Solution {

    long[][] dp;
    int n;
    int l, r;
    List<Integer> lst;
    Map<Integer, Integer> map;
    final long MOD = 1000000007L;

    long fun(int index, int sum) {

        if (sum > r) {
            return 0L;
        }

        if (index == n) {
            if (sum >= l && sum <= r) {
                return 1L;
            }
            return 0L;
        }

        if (dp[index][sum] != -1L) {
            return dp[index][sum];
        }

        int cur = lst.get(index);
        int qty = map.get(cur);

        long ans = 0L;

        ans = (ans + fun(index + 1, sum)) % MOD;

        for (int k = 1; k <= qty; k++) {
            ans = (ans + fun(index + 1, sum + k * cur)) % MOD;
        }

        dp[index][sum] = ans;
        return ans;
    }

    public int countSubMultisets(List<Integer> nums, int l, int r) {

        this.l = l;
        this.r = r;

        map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        lst = new ArrayList<>(map.keySet());
        n = lst.size();

        dp = new long[n][r + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1L);
        }

        return (int)(fun(0, 0) % MOD);
    }
}
