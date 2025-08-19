import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix = new int[n][n];

        for (int[] arr : matrix) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // ✅ Fix: distance from a city to itself should be 0
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];

            matrix[from][to] = w;
            matrix[to][from] = w;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][via] != Integer.MAX_VALUE && matrix[via][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int mincount = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count < min) {
                min = count;
                mincount = i;
            } else if (count == min) {
                mincount = Math.max(mincount, i);
            }
        }

        return mincount;
    }
}
