import java.util.*;

class Solution {

    String s, t;
    int[][] dp;
    Map<Character, List<Integer>> map = new HashMap<>();

    int binary_search(int index, List<Integer> lst) {

        int low = 0;
        int high = lst.size() - 1;

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (lst.get(mid) <= index) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    int check(char c, int index) {

        List<Integer> lst = map.get(c);
        if (lst == null) return -1;

        int pos = binary_search(index, lst); 
        if (pos != -1) {
            return lst.get(pos);
        }

        return -1;
    }

    int fun(int i, int j) {
        if (i >= s.length()) return 0;

        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        char c = s.charAt(i);

        int take = 0;
        int index = check(c, j);
        if (index != -1) {
            take = 1 + fun(i + 1, index);
        }

        int skip = fun(i + 1, j);

        return dp[i][j + 1] = Math.max(take, skip);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        s = text1;
        t = text2;

        dp = new int[s.length()][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }

       
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        return fun(0, -1);
    }
}
