class Solution {
    public int numSub(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        long count = 0;
        long mod = 1000000007;

        while (j < n) {
            if (s.charAt(j) == '1') {
                j++;
            } else {
                int len = j - i;
                count = (count + (long) len * (len + 1) / 2) % mod;
                while (j < n && s.charAt(j) != '1') {
                    j++;
                }
                i = j;
            }
        }

        int len = j - i;
        count = (count + (long) len * (len + 1) / 2) % mod;

        return (int) count;
    }
}
