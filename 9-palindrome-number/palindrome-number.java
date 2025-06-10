class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        // Single-digit numbers are palindromes
        if (x < 10) {
            return true;
        }
        
        int original = x;
        int reversed = 0;
        
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        return original == reversed;
    }
}