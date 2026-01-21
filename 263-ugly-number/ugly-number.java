class Solution {

    boolean isPrime(int c) {
        if (c < 2) return false;
        if (c == 2) return true;

        for (int i = 2; i * i <= c; i++) {
            if (c % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly(int n) {

        if (n <= 0) return false;

        int len = (int)Math.sqrt(n);

        for (int i = 2; i <= len; i++) {
            while (n % i == 0) {
                if (isPrime(i)) {
                    if (i != 2 && i != 3 && i != 5) {
                        if (n % i == 0) {
                            return false;
                        }
                    }
                }
                n = n / i;
            }
        }

        if (n > 1 && n != 2 && n != 3 && n != 5) {
            return false;
        }

        return true;
    }
}
