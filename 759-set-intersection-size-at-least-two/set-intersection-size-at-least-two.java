import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        Arrays.sort(intervals, (x, y) -> {
            int c = Integer.compare(x[1], y[1]);
            if (c == 0) c = Integer.compare(y[0], x[0]);
            return c;
        });

        int n = intervals.length;

        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            if ((end - start + 1) <= 2) {
                if (!set.contains(start)) {
                    list.add(start);
                    set.add(start);
                }
                if (end != start && !set.contains(end)) {
                    list.add(end);
                    set.add(end);
                }
            } else {

                int count = 0;
                int last = list.size() - 1;

                if (last >= 0 && list.get(last) >= start) {

                    while (last >= 0 && list.get(last) > end) last--;
                    int idx = last;
                    while (idx >= 0 && list.get(idx) >= start) {
                        count++;
                        idx--;
                    }

                    if (count == 2) {
                        continue;
                    }

                    if (count == 0) {
                        if (!set.contains(end - 1)) {
                            list.add(end - 1);
                            set.add(end - 1);
                        }
                        if (!set.contains(end)) {
                            list.add(end);
                            set.add(end);
                        }
                    } else if (count == 1) {
                        if (!set.contains(end)) {
                            list.add(end);
                            set.add(end);
                        }
                    }

                } else {

                    if (!set.contains(end - 1)) {
                        list.add(end - 1);
                        set.add(end - 1);
                    }
                    if (!set.contains(end)) {
                        list.add(end);
                        set.add(end);
                    }
                }
            }
        }

        return list.size();
    }
}
