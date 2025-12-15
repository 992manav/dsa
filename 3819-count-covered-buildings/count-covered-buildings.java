class Solution {
    public int countCoveredBuildings(int n, int[][] ar) {
        int ans = 0;
        int[] maxX = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] minY = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            minX[i] = n + 1;
            minY[i] = n + 1;
        }

        for (int i = 0; i < ar.length; i++) {
            int x = ar[i][0];
            int y = ar[i][1];

            maxX[x] = Math.max(maxX[x], y);
            maxY[y] = Math.max(maxY[y], x);
            minX[x] = Math.min(minX[x], y);
            minY[y] = Math.min(minY[y], x);
        }

        for (int i = 0; i < ar.length; i++) {
            int x = ar[i][0];
            int y = ar[i][1];

            if (x > minY[y] && x < maxY[y] && y > minX[x] && y < maxX[x]) {
                ans++;
            }
        }

        return ans;
    }
}
