class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        int j = 1;
        long count = 0;
        int n = prices.length;

        while (j < n) {
            if (j > 0 && prices[j] == prices[j - 1]-1) {
                j++;
            } else {

                int x = j - i;
                count += (long) x * (x + 1) / 2;
                System.out.println(j + " " + i);
                i = j;
                j++;
            }
        }

        int x = j - i;
        count += (long) x * (x + 1) / 2;

        return count;
    }
}
