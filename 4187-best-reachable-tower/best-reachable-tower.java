import java.util.*;

class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
                return b[2] - a[2];
            }
        );

        for (int i = 0; i < towers.length; i++) {
            if (calc(towers[i], center) <= radius) {
                pq.add(towers[i]);
            }
        }

        int[] ans = pq.poll();

        if (ans == null) {
            return new int[]{-1, -1};
        }

        return new int[]{ans[0], ans[1]};
    }

    int calc(int[] tower, int[] center) {
        return Math.abs(tower[0] - center[0]) + Math.abs(tower[1] - center[1]);
    }
}
