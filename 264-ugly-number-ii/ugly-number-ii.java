import java.util.*;

class Solution {

    PriorityQueue<Integer> pq;
    HashSet<Integer> seen;
    int n;

    void fun(int p2, int p3, int p5, int idx) {

        if (idx == 4) {

            int val = 1;

            for (int i = 0; i < p2; i++) {
                if (val > Integer.MAX_VALUE / 2) return;
                val *= 2;
            }

            for (int i = 0; i < p3; i++) {
                if (val > Integer.MAX_VALUE / 3) return;
                val *= 3;
            }

            for (int i = 0; i < p5; i++) {
                if (val > Integer.MAX_VALUE / 5) return;
                val *= 5;
            }

            if (!seen.contains(val)) {
                seen.add(val);
                pq.add(val);
            }

            return;
        }

        if (idx == 1) {
            for (int i = 0; i <= 30; i++) {
                fun(p2 + i, p3, p5, 2);
            }
        } 
        else if (idx == 2) {
            for (int i = 0; i <= 20; i++) {
                fun(p2, p3 + i, p5, 3);
            }
        } 
        else {
            for (int i = 0; i <= 14; i++) {
                fun(p2, p3, p5 + i, 4);
            }
        }
    }

    public int nthUglyNumber(int n) {

        this.n = n;
        pq = new PriorityQueue<>();
        seen = new HashSet<>();

        fun(0, 0, 0, 1);

        while (n > 1) {
            pq.poll();
            n--;
        }

        return pq.poll();
    }
}
