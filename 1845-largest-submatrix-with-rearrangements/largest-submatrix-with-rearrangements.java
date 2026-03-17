import java.util.*;

class Solution {

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public int largestSubmatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxArea = 0;

        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] += mat[i-1][j];
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            int[] row = mat[i].clone();
            Arrays.sort(row);

            int[] nse = findNSE(row);
            int[] pse = findPSE(row);

            for(int k = 0; k < cols; k++) {
                if(row[k] == 0) continue;
                int height = row[k];
                int bestStart = pse[k] + 1;
                int bestEnd = nse[k] - 1;
                int width = (bestEnd - bestStart) + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}