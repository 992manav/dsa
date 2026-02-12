import java.util.*;

class Solution {
    public String longestPrefix(String s) {

        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        lps[0] = 0;

        while (i < n) {

            char c = s.charAt(i);
            char end = s.charAt(len);

            if (c == end) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        return s.substring(0, lps[n - 1]);
    }
}
