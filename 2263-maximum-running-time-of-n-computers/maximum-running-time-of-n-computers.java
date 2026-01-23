import java.util.*;

class Solution {
    public long maxRunTime(int n, int[] batteries) {

        Arrays.sort(batteries);
        int m = batteries.length;

        long extra = 0;
        for (int i = 0; i < m - n; i++) {
            extra += batteries[i];
        }

        long curr = batteries[m - n];
        long count = 1;

        for (int i = m - n + 1; i < m; i++) {

            long next = batteries[i];
            long diff = next - curr;
            long need = count * diff;

            if (need > extra) {
                return curr + extra / count;
            }

            extra -= need;
            curr = next;
            count++;
        }

        return curr + extra / count;
    }
}
