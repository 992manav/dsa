import java.util.*;

class Pair implements Comparable<Pair> {
    int start;
    int duration;

    Pair(int s, int d) {
        start = s;
        duration = d;
    }

    @Override
    public int compareTo(Pair other) {
        int x = this.start - other.start;
        if (x == 0) return this.duration - other.duration;
        return x;
    }
}

class Solution {

    List<Pair> lst;
    int n;

    int binary_search(int key) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (lst.get(mid).start < key) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    int fun(int[] lT, int[] lD, int[] wT, int[] wD) {
        int min_end = Integer.MAX_VALUE;

        for (int i = 0; i < lT.length; i++) {
            int x = lT[i] + lD[i];
            if (x < min_end) min_end = x;
        }

        lst = new ArrayList<>();
        for (int i = 0; i < wT.length; i++) {
            lst.add(new Pair(wT[i], wD[i]));
        }

        Collections.sort(lst);
        n = lst.size();

        int idx = binary_search(min_end);

        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Pair p = lst.get(i);

            int st;
            if (p.start >= min_end) st = p.start;
            else st = min_end;

            int fin = st + p.duration;

            if (fin < best) best = fin;
        }

        return best;
    }

    public int earliestFinishTime(int[] lT, int[] lD, int[] wT, int[] wD) {
        int a = fun(lT, lD, wT, wD);
        int b = fun(wT, wD, lT, lD);

        int result;
        if (a < b) result = a;
        else result = b;

        return result;
    }
}
