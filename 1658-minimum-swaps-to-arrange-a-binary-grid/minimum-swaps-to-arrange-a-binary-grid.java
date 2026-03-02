import java.util.*;

class Solution {

    int[][] grid;
    int n, m;

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int minSwaps(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int ans = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = m - 1; j > 0 && grid[i][j] == 0; j--) {
                count++;
            }
            arr[i] = count;
        }

        int[] target = arr.clone();
        Arrays.sort(target);

        for (int i = 0; i < n / 2; i++) {
            swap(target, i, n - 1 - i);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr));
            if (arr[i] <m-1-i ) {
                
                // System.out.println(target[i]);
                if(target[i]  <m-1-i){
                    return -1;
                }

                int j;
                for (j = i + 1; j < n; j++) {
                    if (arr[j]>=m-1-i) {
                        break;
                    }
                }

                if (j == n) return -1;

                for (; j > i; j--) {
                    swap(arr, j, j - 1);
                    ans++;
                }
                
            }
        }

      
        return ans;
    }
}