import java.util.*;

class Solution {
    public int[][] insert(int[][] intv, int[] newintv) {
        int left = newintv[0];
        int right = newintv[1];
        boolean merged = false;

        for (int i = 0; i < intv.length; i++) {
            int start = intv[i][0];
            int end = intv[i][1];

            if (start <= left && right <= end) {
                return intv;
            }

            if (start <= left && left <= end) {
                if (right <= end) {
                    return mergeAndReturn(intv, newintv);
                }
                intv[i][0] = -1;
                intv[i][1] = -1;
                left = start;
                merged = true;
            } else if (start > left && end < right) {
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            } else if (start >= left && start <= right) {
                intv[i][0] = -1;
                intv[i][1] = -1;
                right = Math.max(right, end);
                merged = true;
            } else if (start == right) {
                intv[i][0] = -1;
                intv[i][1] = -1;
                right = end;
                merged = true;
            } else if (end == left) {
                intv[i][0] = -1;
                intv[i][1] = -1;
                left = start;
                merged = true;
            }
        }

        List<int[]> lst = new ArrayList<>();
        boolean added = false;

        for (int i = 0; i < intv.length; i++) {
            if (intv[i][0] == -1 && intv[i][1] == -1) {
                if (!added) {
                    lst.add(new int[]{left, right});
                    added = true;
                }
            } else {
                lst.add(intv[i]);
            }
        }

        if (!merged && !added) {
            int pos = 0;
            while (pos < lst.size() && lst.get(pos)[0] < left) pos++;
            lst.add(pos, new int[]{left, right});
        }

        int[][] res = new int[lst.size()][];
        for (int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }

    private int[][] mergeAndReturn(int[][] intv, int[] newintv) {
        List<int[]> list = new ArrayList<>();
        boolean added = false;
        for (int[] in : intv) {
            if (!added && newintv[0] < in[0]) {
                list.add(newintv);
                added = true;
            }
            list.add(in);
        }
        if (!added) list.add(newintv);
        return list.toArray(new int[list.size()][]);
    }
}
