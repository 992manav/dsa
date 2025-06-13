class Solution {

    long final_ans = 0;

    void fun(long dividend, long divisor, int two_power, long ans) {
        if (dividend < divisor) {
            return;
        }

        if (dividend - (divisor << two_power) < 0) {
            final_ans += ans;
            two_power--;
            fun(dividend - (divisor << two_power), divisor, 0, 0);
            return;
        }

        fun(dividend, divisor, two_power + 1, (1L << two_power));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;  // edge case overflow

        int sign = 1;
        long ldividend = dividend;
        long ldivisor = divisor;

        if (ldividend < 0) {
            sign *= -1;
            ldividend = -ldividend;
        }

        if (ldivisor < 0) {
            sign *= -1;
            ldivisor = -ldivisor;
        }

        fun(ldividend, ldivisor, 0, 0);
        return (int)(sign * final_ans);
    }
}
