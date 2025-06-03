class Solution {

    double res = 1;

    private double pow(double x, long exp, double res) {
        if (exp == 0) {
            return res;
        }
        if (exp % 2 == 0) {
            return pow(x * x, exp / 2, res);
        } else {
            return pow(x, exp - 1, res * x);
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        long exp = n;
        if (n < 0) {
            exp = -1L * n;
        }

        double res = pow(x, exp, 1);

        if (n < 0) {
            return 1 / res;
        }
        return res;
    }
}
