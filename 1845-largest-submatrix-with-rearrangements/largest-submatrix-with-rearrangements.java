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

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = n;
            }

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

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = -1;
            }

            st.push(i);
        }

        return ans;
    }

    public int largestSubmatrix(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;

        int[] heights = new int[c];
        int maxArea = 0;

        for(int i = 0; i < r; i++){

            for(int j = 0; j < c; j++){
                if(mat[i][j] == 0){
                    heights[j] = 0;
                }else{
                    heights[j] = heights[j] + 1;
                }
            }

            int[] temp = heights.clone();
            Arrays.sort(temp);

            int[] nse = findNSE(temp);
            int[] pse = findPSE(temp);

            int n = temp.length;

            for(int j = 0; j < n; j++){

                int currHeight = temp[j];

                int bestStart = pse[j] + 1;
                int bestEnd = nse[j] - 1;

                int possibleWidth = (bestEnd - bestStart) + 1;

                int currArea = currHeight * possibleWidth;

                if(currArea > maxArea){
                    maxArea = currArea;
                }
            }
        }

        return maxArea;
    }
}