import java.util.*;

class Solution {

    // Helper class to store one rectangle
    static class Pair {
        int blx;   // bottom-left x
        int bly;   // bottom-left y
        int trx;   // top-right x
        int tryy;  // top-right y

        Pair(int blx, int bly, int trx, int tryy) {
            this.blx = blx;
            this.bly = bly;
            this.trx = trx;
            this.tryy = tryy;
        }
    }

    public long largestSquareArea(int[][] bL, int[][] tR) {

        int n = bL.length;

        // Store all rectangles as Pair objects
        List<Pair> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lst.add(new Pair(
                bL[i][0],   // bottom-left x
                bL[i][1],   // bottom-left y
                tR[i][0],   // top-right x
                tR[i][1]    // top-right y
            ));
        }

        // Sort rectangles by:
        // 1) blx (left boundary)
        // 2) bly
        // 3) trx
        // 4) tryy
        // This helps in sweeping from left to right
        Collections.sort(lst, (a, b) -> {
            if (a.blx != b.blx) return a.blx - b.blx;
            if (a.bly != b.bly) return a.bly - b.bly;
            if (a.trx != b.trx) return a.trx - b.trx;
            return a.tryy - b.tryy;
        });

        // Queue to store "active" rectangles that can still overlap
        Queue<Pair> q = new LinkedList<>();

        // Min-heap based on trx (right boundary)
        // Used to remove rectangles that no longer overlap in x-direction
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.trx - b.trx
        );

        long ans = 0; // maximum square area found so far

        // Sweep through rectangles one by one
        for (int i = 0; i < n; i++) {

            Pair p = lst.get(i);

            // Remove rectangles whose right boundary is completely
            // left of current rectangle's left boundary
            while (!pq.isEmpty() && pq.peek().trx < p.blx) {
                Pair rem = pq.poll();
                q.remove(rem);
            }

            // Check intersection of current rectangle
            // with all active rectangles
            for (Pair prev : q) {

                // Compute intersection boundaries
                int left = Math.max(p.blx, prev.blx);
                int right = Math.min(p.trx, prev.trx);

                int bottom = Math.max(p.bly, prev.bly);
                int top = Math.min(p.tryy, prev.tryy);

                int width = right - left;
                int height = top - bottom;

                // Valid intersection exists
                if (width > 0 && height > 0) {

                    // Largest square side inside intersection
                    int side = Math.min(width, height);

                    // Update maximum square area
                    ans = Math.max(ans, (long) side * side);
                }
            }

            // Add current rectangle to active sets
            q.add(p);
            pq.add(p);
        }

        return ans;
    }
}
