class Solution {
    public int minSteps(int n) {
        int count = 0;
        while (n % 2 == 0) {
            count += 2;
            n = n / 2;
        }

        if (n != 1) {
            for (int i = 3; i * i <= n; i++) {
                if (n % i == 0) {
                    while (n % i == 0) {
                        count += i;
                        n = n / i;
                    }
                }
            }

            if (n != 1) {
                count += n;
            }
        }

        return count;
    }
}
