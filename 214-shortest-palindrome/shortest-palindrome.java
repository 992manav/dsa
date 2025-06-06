class Solution {
    static final long mod = 1000000007;
    static final long base = 131;

    // get substring hash from prefix hashes
    private long getHash(long[] prefixHash, long[] power, int l, int r) {
        long hash = prefixHash[r + 1] - (prefixHash[l] * power[r - l + 1]) % mod;
        if (hash < 0) hash += mod;
        return hash;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % mod;
        }

        long[] prefixHash = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixHash[i + 1] = (prefixHash[i] * base + (s.charAt(i) - 'a' + 1)) % mod;
        }

        // For suffix hash, do similar but reversed string
        String rev = new StringBuilder(s).reverse().toString();
        long[] suffixHash = new long[n + 1];
        for (int i = 0; i < n; i++) {
            suffixHash[i + 1] = (suffixHash[i] * base + (rev.charAt(i) - 'a' + 1)) % mod;
        }

        int longestPali = 0;
        for (int len = n; len >= 1; len--) {
            long leftHash = getHash(prefixHash, power, 0, len - 1);
            long rightHash = getHash(suffixHash, power, n - len, n - 1);

            if (leftHash == rightHash) {
                longestPali = len;
                break;
            }
        }

        String suffix = s.substring(longestPali);
        StringBuilder sb = new StringBuilder(suffix).reverse();
        return sb.toString() + s;
    }
}
