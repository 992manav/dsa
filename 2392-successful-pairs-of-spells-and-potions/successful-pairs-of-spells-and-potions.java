import java.util.*;

class Solution {

    public int bs(int[] arr, int x, long min) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((long) arr[mid] * x >= min) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] successfulPairs(int[] s, int[] p, long min) {

        Arrays.sort(p);
        int[] res = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            int count = p.length - bs(p, s[i], min);
            res[i] = count;
        }
        return res;
    }
}
