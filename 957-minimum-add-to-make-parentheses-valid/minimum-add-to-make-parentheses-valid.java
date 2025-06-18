class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0; // Tracks unmatched '('
        int right = 0; // Tracks unmatched ')'

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--; // Match one '(' with ')'
                } else {
                    right++; // Extra ')'
                }
            }
        }

        return count + right; // Total unmatched
    }
}
