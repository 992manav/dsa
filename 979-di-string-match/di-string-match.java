import java.util.*;

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();

        int[] min = new int[n + 1];
        int[] max = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            min[i] = i;
            max[i] = n;
        }

        int[] res = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'I') {
                res[i] = min[i];
                min[i + 1] = min[i] + 1;
                max[i+1]=max[i];
            } else {
                res[i] = max[i];
                max[i + 1] = max[i] - 1;
                min[i + 1] = min[i];
            }
        }

        res[n] = min[n];
        return res;
    }
}
