class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        long base = 27; // a random base
        long mod = 1000000007; // a large prime
        long hash_forward = 0;
        long hash_backward = 0;
        long power = 1;
        int longestPalindromePrefix = 0;

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a' + 1;

            hash_forward = (hash_forward * base + ch) % mod;
            hash_backward = (hash_backward + power * ch) % mod;

            if (hash_forward == hash_backward) {
                longestPalindromePrefix = i + 1;
            }

            power = (power * base) % mod;
        }

        // The part after the palindromic prefix
        String suffix = s.substring(longestPalindromePrefix);
        StringBuilder rev = new StringBuilder(suffix).reverse();

        return rev.append(s).toString();
    }
}
