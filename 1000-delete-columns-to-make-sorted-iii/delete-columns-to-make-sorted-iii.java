import java.util.*;

class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;

        int[] lis = new int[cols];
        Arrays.fill(lis, 1);

        for (int currCol = 1; currCol < cols; currCol++) {
            for (int prevCol = 0; prevCol < currCol; prevCol++) {
                if (isNonDecreasing(strs, prevCol, currCol)) {
                    lis[currCol] = Math.max(lis[currCol], lis[prevCol] + 1);
                }
            }
        }

        int maxLis = 0;
        for (int len : lis) {
            maxLis = Math.max(maxLis, len);
        }

        return cols - maxLis;
    }

    private boolean isNonDecreasing(String[] strs, int leftCol, int rightCol) {
        for (String row : strs) {
            if (row.charAt(leftCol) > row.charAt(rightCol)) {
                return false;
            }
        }
        return true;
    }
}
