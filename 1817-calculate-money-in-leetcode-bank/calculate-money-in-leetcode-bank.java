class Solution {
    public int totalMoney(int n) {
        int q = n / 7;

        int m = q + 3;
        int sum = 0;

        if (q > 0) {
            sum = 7 * m * (m + 1) / 2 - 42;
        }

        int r = n % 7;

        int start = q + 1;

        int cur = 0;
        for (int i = 0; i < r; i++) {
            cur += start;
            start++;
        }

        return sum + cur;
    }
}
