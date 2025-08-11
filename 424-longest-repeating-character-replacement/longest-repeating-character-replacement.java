class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;
        int r = 0;
        int len = 0;
        int max_count = 0;
        int max_length = 0;

        int[] freq = new int[26];

        while (r < s.length()) {

            char c = s.charAt(r);
            freq[c - 'A']++;
            if (freq[c - 'A'] > max_count) {
                max_count = freq[c - 'A'];
            }

            len++;  // window size increased by 1

            while (len - max_count > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
                len--;
            }

            if (len > max_length) {
                max_length = len;
            }
            r++;
        }
        return max_length;
    }
}
