import java.util.*;

class Solution {
    static int[] X = {1,11,111,1111,11111,111111};

    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || k % 5 == 0) return -1;

        int pos = Arrays.binarySearch(X, k);
        int len = pos >= 0 ? pos + 1 : -pos;

        int r = X[len - 1] % k;
        if (r == 0) return len;

        while (true) {
            len++;
            r = (10 * r + 1) % k;
            if (r == 0) return len;
        }
    }
}
