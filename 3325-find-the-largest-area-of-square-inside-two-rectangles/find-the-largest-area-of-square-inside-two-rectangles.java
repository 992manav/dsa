import java.util.*;

class Solution {

    static class Pair {
        int blx;
        int bly;
        int trx;
        int tryy;

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

        Stack<Pair> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {

            Pair p = lst.get(i);
            Stack<Pair> tmp = new Stack<>();

            // 🔑 check with ALL previous rectangles
            while (!st.isEmpty()) {

                Pair prev = st.pop();

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

                tmp.push(prev);
            }

            // restore original stack
            while (!tmp.isEmpty()) {
                st.push(tmp.pop());
            }

            st.push(p);
        }

        return ans;
    }
}
