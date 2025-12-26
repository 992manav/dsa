class Solution {
    public int bestClosingTime(String customers) {

        String s = customers;
        int n = s.length();

        int[] suffix_y = new int[n + 1];
        int[] prefix_n = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == 'N') {
                prefix_n[i] = prefix_n[i - 1] + 1;
            } else {
                prefix_n[i] = prefix_n[i - 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'Y') {
                suffix_y[i] = suffix_y[i + 1] + 1;
            } else {
                suffix_y[i] = suffix_y[i + 1];
            }
        }

        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i <= n; i++) {
            int count = prefix_n[i] + suffix_y[i];
            if (count < min) {
                min = count;
                min_index = i;
            }
        }

        return min_index;
    }
}
