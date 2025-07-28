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
                left = start;
                if (right <= end) {
                    right = end;
                }
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            } else if (start > left && end < right) {
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            } else if (start >= left && start <= right) {
                right = Math.max(right, end);
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            } else if (end == left) {
                left = start;
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            } else if (start == right) {
                right = end;
                intv[i][0] = -1;
                intv[i][1] = -1;
                merged = true;
            }
        }

        List<int[]> ans = new ArrayList<>();
        boolean added = false;

        for (int i = 0; i < intv.length; i++) {
            if (intv[i][0] == -1 && intv[i][1] == -1) {
                if (!added) {
                    ans.add(new int[]{left, right});
                    added = true;
                }
            } else {
                ans.add(intv[i]);
            }
        }

        if (!merged && !added) {
            int pos = 0;
            while (pos < ans.size() && ans.get(pos)[0] < left) pos++;
            ans.add(pos, new int[]{left, right});
        }

        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
