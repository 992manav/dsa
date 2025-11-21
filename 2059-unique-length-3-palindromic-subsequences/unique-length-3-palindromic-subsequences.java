import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(c, lst);
            }
        }

        for (char key : map.keySet()) {
            List<Integer> lst = map.get(key);
            int size = lst.size();

            if (size >= 2) {
                int first = lst.get(0);
                int last = lst.get(size - 1);
                boolean[] seen = new boolean[26];

                for (int k = first + 1; k < last; k++) {
                    char mid = s.charAt(k);
                    seen[mid - 'a'] = true;
                }

                for (int x = 0; x < 26; x++) {
                    if (seen[x]) count++;
                }
            }
        }

        return count;
    }
}
