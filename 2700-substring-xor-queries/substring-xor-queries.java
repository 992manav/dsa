import java.util.*;

class Solution {

    int find(int num, Map<Integer, Integer> map) {
        return map.getOrDefault(num, -1);
    }

    int calc(int num, int r) {
        int len = 0;
        while (num != 0) {
            num >>= 1;
            len++;
        }
        return Math.max(0, r - len + 1); // safe: avoid negative index
    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int first_zero = -1;
        int first_one = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && first_zero == -1) {
                first_zero = i;
            }
            if (s.charAt(i) == '1' && first_one == -1) {
                first_one = i;
            }

            if (s.charAt(i) == '1') {
                int num = 0;
                for (int j = i; j < s.length() && j < i + 32; j++) {
                    num <<= 1;
                    if (s.charAt(j) == '1') {
                        num += 1;
                    }
                    if (!map.containsKey(num)) {
                        map.put(num, j);
                    }
                }
            }
        }

        int[][] ans = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            int xor = queries[i][0] ^ queries[i][1];

            if (xor == 0) {
                ans[i] = (first_zero == -1) ? new int[]{-1, -1} : new int[]{first_zero, first_zero};
                continue;
            }
            if (xor == 1) {
                ans[i] = (first_one == -1) ? new int[]{-1, -1} : new int[]{first_one, first_one};
                continue;
            }

            int r = find(xor, map);
            if (r == -1) {
                ans[i] = new int[]{-1, -1};
            } else {
                int l = calc(xor, r);
                ans[i] = new int[]{l, r};
            }
        }
        return ans;
    }
}
