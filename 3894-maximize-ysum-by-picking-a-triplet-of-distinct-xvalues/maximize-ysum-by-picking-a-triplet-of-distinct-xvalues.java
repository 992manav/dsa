import java.util.*;

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        int[] arr = new int[1000001];

        for (int i = 0; i < n; i++) {
            int index = x[i] - 1;
            arr[index] = Math.max(arr[index], y[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int count = 0;

        for (int i = 1000000; i >= 0; i--) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
            if (count == 3) {
                return sum;
            }
        }

        return -1;
    }
}
