class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int[] suffixb = new int[n + 1];
        int[] suffixa = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                suffixb[i] = suffixb[i + 1] + 1;
                suffixa[i] = suffixa[i + 1];
            } else {
                suffixa[i] = suffixa[i + 1] + 1;
                suffixb[i] = suffixb[i + 1];
            }
        }

        int[] prefixa = new int[n];
        int[] prefixb = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                prefixa[i] = (i > 0 ? prefixa[i - 1] : 0) + 1;
                prefixb[i] = (i > 0 ? prefixb[i - 1] : 0);
            } else {
                prefixa[i] = (i > 0 ? prefixa[i - 1] : 0);
                prefixb[i] = (i > 0 ? prefixb[i - 1] : 0) + 1;
            }
        }

        int min = n;
        for (int i = 0; i < n; i++) {
            int remove = prefixb[i] + suffixa[i];
            min = Math.min(min, remove);
        }

        return min-1;
    }
}
