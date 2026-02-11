class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid=new int[n][n];


        int num=1;

        int l=0;
        int r=n-1;
        int u=0;
        int d=n-1;


        while(l<=r || u<=d){


            for(int i=l;i<=r;i++){
                grid[u][i]=num;
                num++;
            }



            for(int i=u+1;i<=d;i++){
                grid[i][r]=num;
                num++;
            }

            if(u<d){
                    for(int i=r-1;i>=l;i--){
                        grid[d][i]=num;
                        num++;
                    }
            }
            
            if(l<r){
                    for(int i=d-1;i>u;i--){
                        grid[i][l]=num;
                        num++;
                    }
            }
            

            l++;
            r--;
            u++;
            d--;
        }

        return grid;

    }
}