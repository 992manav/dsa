public class Solution {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int xor = 0, xor2 = 0;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ch1 = s.charAt(i) - 'a';
            int ch2 = t.charAt(i) - 'a';

            xor ^= ch1;
            xor2 ^= ch2;

            count[ch1]++;
            count[ch2]--;
        }

        if (xor == xor2) {
            for (int c : count) {
                if (c != 0) return false;
            }
            return true;
        }

        return false;
    }
}