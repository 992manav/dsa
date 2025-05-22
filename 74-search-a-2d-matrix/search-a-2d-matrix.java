class Solution { 

    int target; 

    boolean binary_search(int[][] matrix, int low, int high, int n) { 
        while(low <= high) { 
            int mid = (low + high) / 2; 
            int x = mid / n;  // integer division floors automatically
            int y = mid % n; 

            if(matrix[x][y] == target) { 
                return true;    
            } 

            if(matrix[x][y] < target) { 
                low = mid + 1; 
            } else { 
                high = mid - 1; 
            } 
        } 
        return false; 
    } 

    public boolean searchMatrix(int[][] matrix, int target) { 
        this.target = target; 
        int m = matrix.length; 
        int n = matrix[0].length; 
        // high should be m*n - 1, since last index is zero-based
        return binary_search(matrix, 0, m * n - 1, n); 
    } 
}
