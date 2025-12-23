import java.util.*;

class Solution {

    int n;
    int[] prefix;
    int[][] events;

    int binary_search(int start) {
        int low = 0;
        int high = n - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (events[mid][1] < start) {
                ans = Math.max(ans, prefix[mid]);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int maxTwoEvents(int[][] events) {

        this.events = events;
        n = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        prefix = new int[n];
        prefix[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int best = binary_search(start);
            ans = Math.max(ans, best + events[i][2]);
        }

        return ans;
    }
}
