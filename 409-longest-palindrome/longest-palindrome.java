import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = 0;
        boolean oddFound = false;
        for (int value : map.values()) {
            if (value % 2 == 0) {
                len += value;
            } else {
                len += value - 1;  // use the even part
                oddFound = true;   // mark that odd count exists
            }
        }

        if (oddFound) {
            len += 1;  // add one odd character in the middle
        }

        return len;
    }
}
