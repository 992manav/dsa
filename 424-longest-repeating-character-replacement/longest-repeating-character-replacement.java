class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[][] cnt = new int[26][n];

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            for (int i = 0; i < n; i++) {

                if (i == 0) {
                    if (s.charAt(i) == ch) {
                        cnt[ch - 'A'][i] = 1;
                    }
                    continue;
                }

                if (s.charAt(i) == ch) {
                    cnt[ch - 'A'][i] = cnt[ch - 'A'][i - 1] + 1;
                } else {
                    cnt[ch - 'A'][i] = cnt[ch - 'A'][i - 1];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int low = i;
            int high = n - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                int noOfEle = cnt[s.charAt(i) - 'A'][mid];

                if (i != 0) {
                    noOfEle -= cnt[s.charAt(i) - 'A'][i - 1];
                }

                int len = mid - i + 1;
                int extra_needed = len - noOfEle;

                if (extra_needed <= k) {
                    int temp = k - extra_needed;
                    ans = Math.max(ans, Math.min(n, temp + len));
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
    }
}