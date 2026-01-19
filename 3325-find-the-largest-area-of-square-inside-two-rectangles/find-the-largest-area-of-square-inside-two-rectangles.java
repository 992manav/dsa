import java.util.*;

class Solution {

    static class Pair {
        int blx, bly, trx, tryy;

        Pair(int blx, int bly, int trx, int tryy) {
            this.blx = blx;
            this.bly = bly;
            this.trx = trx;
            this.tryy = tryy;
        }
    }

    public long largestSquareArea(int[][] bL, int[][] tR) {

        int n = bL.length;
        List<Pair> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lst.add(new Pair(
                bL[i][0],
                bL[i][1],
                tR[i][0],
                tR[i][1]
            ));
        }

        Collections.sort(lst, (a, b) -> {
            if (a.blx != b.blx) return a.blx - b.blx;
            if (a.bly != b.bly) return a.bly - b.bly;
            if (a.trx != b.trx) return a.trx - b.trx;
            return a.tryy - b.tryy;
        });

        TreeSet<Pair> active = new TreeSet<>(
            (a, b) -> {
                if (a.trx != b.trx) return a.trx - b.trx;
                return System.identityHashCode(a) - System.identityHashCode(b);
            }
        );

        long ans = 0;

        for (Pair p : lst) {

            while (!active.isEmpty() && active.first().trx < p.blx) {
                active.pollFirst();
            }

            for (Pair prev : active) {

                int left = Math.max(p.blx, prev.blx);
                int right = Math.min(p.trx, prev.trx);
                int bottom = Math.max(p.bly, prev.bly);
                int top = Math.min(p.tryy, prev.tryy);

                int width = right - left;
                int height = top - bottom;

                if (width > 0 && height > 0) {
                    int side = Math.min(width, height);
                    ans = Math.max(ans, (long) side * side);
                }
            }

            active.add(p);
        }

        return ans;
    }
}
