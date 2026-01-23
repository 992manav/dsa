import java.util.*;

// Pair class: ek job ko represent karta hai
// prof  -> job ka profit
// diff  -> job ki minimum difficulty
class Pair {
    int prof;
    int diff;

    Pair(int prof, int diff) {
        this.prof = prof;
        this.diff = diff;
    }
}

class Solution {

    // Binary search:
    // workers[low..high] mein pehla worker dhoondo
    // jiska strength >= target (job difficulty)
    int binary_search(int target, int[] workers, int low, int high) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // agar worker job kar sakta hai
            if (workers[mid] >= target) {
                ans = mid;          // possible answer store karo
                high = mid - 1;     // left side mein aur better (earlier) worker dhoondo
            } else {
                low = mid + 1;      // weak worker → right side jao
            }
        }
        return ans; // first capable worker ka index
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {

        int n = profit.length;

        // Max-heap based on profit
        // zyada profit wali job pehle niklegi
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.prof == b.prof) {
                    return a.diff - b.diff; // same profit → kam difficulty pehle
                }
                return b.prof - a.prof;     // zyada profit pehle
            }
        );

        // saari jobs ko heap mein daalo
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(profit[i], difficulty[i]));
        }

        // workers ko sort karo (weak → strong)
        Arrays.sort(workers);

        // i = strongest available worker ka index
        int i = workers.length - 1;
        int sum = 0; // total profit

        // jab tak jobs bhi bachi hain aur workers bhi
        while (!pq.isEmpty() && i >= 0) {

            // highest profit wali job uthao
            Pair p = pq.poll();
            int prof = p.prof;
            int min_diff = p.diff;

            // strongest se lekar left side tak
            // pehla worker dhoondo jo job kar sake
            int new_i = binary_search(min_diff, workers, 0, i);

            // agar koi worker mil gaya
            if (new_i != -1) {

                // workers[new_i ... i] sab ye job kar sakte hain
                int count = i - new_i + 1;

                // sabko same job assign karo
                sum += prof * count;

                // ab ye workers use ho gaye → bacha hua range update
                i = new_i - 1;
            }
            // agar koi worker capable nahi mila → job skip ho jaati hai
        }

        return sum;
    }
}
