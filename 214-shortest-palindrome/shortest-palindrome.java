class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // Find the longest palindromic prefix
        int end = s.length() - 1;
        int start = 0;
        
        // Move end pointer backwards, start pointer forwards when chars match
        while (end >= 0) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
            }
            end--;
        }
        
        // If start reached the end, the whole string is already a palindrome
        if (start == s.length()) {
            return s;
        }
        
        // Get the non-palindromic suffix
        String suffix = s.substring(start);
        
        // Recursively solve for the palindromic part
        String palindromicPart = shortestPalindrome(s.substring(0, start));
        
        // Build result: reversed suffix + palindromic part + original suffix
        return new StringBuilder(suffix).reverse().toString() + palindromicPart + suffix;
    }
}