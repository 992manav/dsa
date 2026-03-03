class Solution {

    char fun(long n, long k, int i, long shift, int[] ops) {
        if (i < 0) {
            return (char) ('a' + (shift % 26));
        }

        long half = n / 2;

        if (k < half) {
            return fun(half, k, i - 1, shift, ops);
        } else {
            if (ops[i] == 1) {
                shift++;
            }
            return fun(half, k - half, i - 1, shift, ops);
        }
    }

    public char kthCharacter(long k, int[] ops) {
        int last_idx = ops.length - 1;

        long n = 1L;

        for (int i = 0; i < ops.length; i++) {
            n = n * 2;

            if (n > k) {
                last_idx = i;
                break;
            }
        }

        return fun(n, k - 1, last_idx, 0L, ops);
    }
}