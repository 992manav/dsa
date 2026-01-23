import java.util.*;

class Pair {
    int prof;
    int diff;

    Pair(int prof, int diff) {
        this.prof = prof;
        this.diff = diff;
    }
}

class Solution {

    int binary_search(int target, int[] workers, int low, int high) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (workers[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {

        int n = profit.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.prof == b.prof) {
                    return a.diff - b.diff;
                }
                return b.prof - a.prof;
            }
        );

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(profit[i], difficulty[i]));
        }

        Arrays.sort(workers);

        int i = workers.length - 1;
        int sum = 0;

        while (!pq.isEmpty() && i >= 0) {

            Pair p = pq.poll();
            int prof = p.prof;
            int min_diff = p.diff;

            int new_i = binary_search(min_diff, workers, 0, i);

            if (new_i != -1) {
                sum += prof * (i - new_i + 1);
                i = new_i - 1;
            }
        }

        return sum;
    }
}
