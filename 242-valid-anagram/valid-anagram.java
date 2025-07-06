public class Solution {

    public static boolean isAnagram(String s, String t) {
        // Quick length check
        if (s.length() != t.length()) {
            return false;
        }

        int xor = 0;
        int xor2 = 0;
        int[] count = new int[26];

        // Build both xor‑sums and frequency balance in one pass
        for (int i = 0; i < s.length(); i++) {
            xor  ^= s.charAt(i) - 'a';
            xor2 ^= t.charAt(i) - 'a';

            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If the xor‑sums match, verify the counts
        if (xor == xor2) {
            for (int c : count) {
                if (c != 0) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}