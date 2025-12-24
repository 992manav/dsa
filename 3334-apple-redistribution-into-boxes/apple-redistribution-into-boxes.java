import java.util.*;

class Solution {
    public int minimumBoxes(int[] a, int[] cap) {

        int sum = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        Arrays.sort(cap);

        int sum2 = 0;
        int count = 0;

        for (int i = cap.length - 1; i >= 0; i--) {
            sum2 += cap[i];
            count++;

            if (sum2 >= sum) {
                return count;
            }
        }

        return -1;
    }
}
