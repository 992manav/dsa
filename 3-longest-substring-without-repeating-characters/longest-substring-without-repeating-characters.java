class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxlen = 0;

        HashSet<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                maxlen = Math.max(maxlen, set.size());
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
            }
        }

       
        maxlen = Math.max(maxlen, set.size());

        return maxlen;
    }
}
