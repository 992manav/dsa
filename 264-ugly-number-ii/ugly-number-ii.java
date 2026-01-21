import java.util.*;

class Solution {

    PriorityQueue<Integer> pq;
    Set<Integer> seen;

    void fun(int p2, int p3, int p5) {

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
    }

    public int nthUglyNumber(int n) {

        pq = new PriorityQueue<>();
        seen = new HashSet<>();

        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 14; k++) {
                    fun(i, j, k);
                }
            }
        }

        while (n > 1) {
            pq.poll();
            n--;
        }

        return pq.poll();
    }
}
