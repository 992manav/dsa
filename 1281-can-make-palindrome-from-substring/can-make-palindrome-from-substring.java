import java.util.*;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] q) {
        
        int n = s.length();
        int[] arr = new int[26];
        int[][] map = new int[n][26];
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            arr[idx]++;
            map[i] = Arrays.copyOf(arr, 26);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];
            int k = q[i][2];

            int count_odd = 0;

            for (int j = 0; j < 26; j++) {
                int freq;
                if (l == 0) {
                    freq = map[r][j];
                } else {
                    freq = map[r][j] - map[l - 1][j];
                }

                if (freq % 2 != 0) {
                    count_odd++;
                }
            }

            if (count_odd / 2 <= k) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
