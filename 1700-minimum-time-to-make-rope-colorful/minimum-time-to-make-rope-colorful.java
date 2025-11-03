class Solution {
    public int minCost(String colors, int[] nt) {
        char prev = 'A';
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int tot = 0;

        for (int i = 0; i < colors.length(); i++) {
            char curr = colors.charAt(i);

            if (curr == prev) {
                sum += nt[i];
                max = Math.max(nt[i], max);
            } else {
                if (max != Integer.MIN_VALUE) {
                    tot += sum - max;
                }
                sum = nt[i];
                max = nt[i];
            }
            prev = curr;
        }

        if (max != Integer.MIN_VALUE) {
            tot += sum - max;
        }

        return tot;
    }
}
