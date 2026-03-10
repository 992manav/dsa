class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[] changed = new boolean[n];

        int j = 0;
        for(int i = 0; i < n; i++){
            if(grid[i][j] == 0){
                changed[i] = true;
            }
        }

        for(int i = 0; i < n; i++){
            if(changed[i]){
                for(int j1 = 0; j1 < m; j1++){
                    grid[i][j1] ^= 1;
                }
            }
        }

        boolean[] changed_c = new boolean[m];

        for(int j1 = 1; j1 < m; j1++){
            int count=0;
            int count1=0;

            for(int i = 0; i < n; i++){
                if(grid[i][j1] == 1){
                    count++;
                }else{
                    count1++;
                }
            }

            if(count1>count){
                    changed_c[j1] = true;
            }
            
        }

        for(int j1 = 0; j1 < m; j1++){
            if(changed_c[j1]){
                for(int i = 0; i < n; i++){
                    grid[i][j1] ^= 1;
                }
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();

            for(int j1 = 0; j1 < m; j1++){
                if(grid[i][j1] == 1){
                    sb.append('1');
                }else{
                    sb.append('0');
                }
            }

            int x = Integer.parseInt(sb.toString(), 2);
            sum += x;
        }

        return sum;
    }
}