class Solution {
    char fun(long k, int i, long shift, int[] ops) {
        if (i < 0) {
            return (char)('a' + (shift % 26));
        }

        // Use Math.min to cap half, since k < 2^63 anyway
        long half = (i >= 63) ? Long.MAX_VALUE : (1L << i);

        if (k < half) {
            return fun(k, i - 1, shift, ops);
        } else {
            if (ops[i] == 1) {
                shift++;
            }
            return fun(k - half, i - 1, shift, ops);
        }
    }

    public char kthCharacter(long k, int[] ops) {
        return fun(k - 1, ops.length - 1, 0L, ops);
    }
}