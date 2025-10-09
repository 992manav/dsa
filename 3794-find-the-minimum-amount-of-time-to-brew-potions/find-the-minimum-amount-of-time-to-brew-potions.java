import java.util.*;

class Solution {

    int n;
    int[] arr, brr;

    void construct(int ind, long[] future) {
        for (int i = 0; i < n; i++) {
            if (i == 0) future[i] = (long) brr[ind] * arr[i];
            else future[i] = (long) brr[ind] * arr[i] + future[i - 1];
        }
    }

    long findMaxDifference(long[] current, long[] future) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long prevFuture = (i == 0 ? 0 : future[i - 1]);
            long diff = current[i] - prevFuture;
            max = Math.max(max, diff);
        }
        return max;
    }

    long minTime(int[] arr, int[] brr) {
        this.arr = arr;
        this.brr = brr;
        n = arr.length;
        int m = brr.length;

        long[] current = new long[n];
        long[] future = new long[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) current[i] = (long) brr[0] * arr[i];
            else current[i] = (long) brr[0] * arr[i] + current[i - 1];
        }

        for (int i = 1; i < m; i++) {
            construct(i, future);
            long diff = findMaxDifference(current, future);
            for (int j = 0; j < n; j++) current[j] = future[j] + diff;
        }

        return current[n - 1];
    }

}
