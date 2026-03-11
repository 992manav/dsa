class Solution {
    public long maxSum(int[][] grid, int[] limit, int k) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            Arrays.sort(grid[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            int c = limit[i];

            for(int j = m - 1; j >= 0; j--){
                if(c == 0){
                    break;
                }
                pq.add(grid[i][j]);
                c--;
            }
        }

        long sum = 0;

        while(k > 0 && !pq.isEmpty()){
            sum += pq.poll();
            k--;
        }

        return sum;
    }
}