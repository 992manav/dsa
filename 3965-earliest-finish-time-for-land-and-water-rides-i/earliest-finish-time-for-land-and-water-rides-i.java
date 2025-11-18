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

    int fun(int[] lT, int[] lD, int[] wT, int[] wD) {
        int min_end = Integer.MAX_VALUE;

        for (int i = 0; i < lT.length; i++) {
            int finish = lT[i] + lD[i];
            if (finish < min_end) min_end = finish;
        }

        lst = new ArrayList<>();
        for (int i = 0; i < wT.length; i++) {
            lst.add(new Pair(wT[i], wD[i]));
        }

        Collections.sort(lst);

        int best = Integer.MAX_VALUE;

        for (int i = 0; i < lst.size(); i++) {
            Pair p = lst.get(i);

            int startTime;
            if (p.start >= min_end) startTime = p.start;
            else startTime = min_end;

            int finish = startTime + p.duration;
            if (finish < best) best = finish;
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
