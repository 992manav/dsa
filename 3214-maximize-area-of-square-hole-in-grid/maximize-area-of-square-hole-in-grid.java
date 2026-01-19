import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxH = 0;
        int cur = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                cur++;
            } else {
                if (cur > maxH) {
                    maxH = cur;
                }
                cur = 1;
            }
        }
        if (cur > maxH) {
            maxH = cur;
        }

        int maxV = 0;
        cur = 1;

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                cur++;
            } else {
                if (cur > maxV) {
                    maxV = cur;
                }
                cur = 1;
            }
        }
        if (cur > maxV) {
            maxV = cur;
        }

        int holeH = maxH + 1;
        int holeV = maxV + 1;

        int side = Math.min(holeH, holeV);

        return side * side;
    }
}
