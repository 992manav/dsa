import java.util.*;

class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;


        if(cols==1){
            return 0;
        }
        int[] lis = new int[cols];
        Arrays.fill(lis, 1);

        int max_len = 0;

        for (int currCol = 1; currCol < cols; currCol++) {
            for (int prevCol = 0; prevCol < currCol; prevCol++) {
                if (isNonDecreasing(strs, prevCol, currCol)) {
                    int len = Math.max(lis[currCol], lis[prevCol] + 1);
                    lis[currCol] = len;
                }
            }
            max_len = Math.max(max_len, lis[currCol]);
        }

        return cols - max_len;
    }

    private boolean isNonDecreasing(String[] strs, int leftCol, int rightCol) {
        for (String row : strs) {
            if (row.charAt(leftCol) <= row.charAt(rightCol)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
