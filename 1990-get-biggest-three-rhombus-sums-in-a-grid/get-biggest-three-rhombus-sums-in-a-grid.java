import java.util.*;

class Solution {

    int fun(int[][] grid,int r,int c,int size,int n,int m){

        if(size==0){
            return grid[r][c];
        }

        if(r+2*size>=n || c-size<0 || c+size>=m){
            return -1;
        }

        int s=0;
        int i=r;
        int j=c;

        for(int x=0;x<size;x++){
            s+=grid[i][j];
            i++;
            j++;
        }

        for(int x=0;x<size;x++){
            s+=grid[i][j];
            i++;
            j--;
        }

        for(int x=0;x<size;x++){
            s+=grid[i][j];
            i--;
            j--;
        }

        for(int x=0;x<size;x++){
            s+=grid[i][j];
            i--;
            j++;
        }

        return s;
    }

    public int[] getBiggestThree(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int max_size=Math.min((n-i-1)/2,Math.min(j,m-j-1));

                for(int k=0;k<=max_size;k++){
                    int s=fun(grid,i,j,k,n,m);
                    if(s!=-1){
                        pq.offer(s);
                    }
                }
            }
        }

        HashSet<Integer> seen=new HashSet<>();
        int[] ans=new int[3];
        int idx=0;

        while(!pq.isEmpty() && idx<3){
            int v=pq.poll();
            if(!seen.contains(v)){
                ans[idx++]=v;
                seen.add(v);
            }
        }

        if(idx<3){
            ans=Arrays.copyOf(ans,idx);
        }

        return ans;
    }
}