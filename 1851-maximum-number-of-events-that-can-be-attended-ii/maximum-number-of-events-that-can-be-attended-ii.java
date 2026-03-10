class Solution {

    int[][] events;
    int n;
    int[][] dp;
    
    int bs(int i,int target){

        int low=i+1;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;

            if(events[mid][0]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;


    }
    
    int fun(int i,int k){
        if(k==0){
            return 0;
        }

        if(i>=n){
            return Integer.MIN_VALUE;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        int val = events[i][2];
        int take = val;

        int  idx=bs(i,events[i][1]);
        take = Math.max(take,fun(idx,k-1) + val);
        
        int skip = fun(i+1,k);

        // System.out.println(i);
        // System.out.println(take);
        // System.out.println(skip);

        if(take > skip){
            return dp[i][k]=take;
        }
        else{
            return dp[i][k]=skip;
        }

    }

    public int maxValue(int[][] events, int k) {

        this.events = events;
        n = events.length;
        dp=new int[n+1][k+1];

        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }


        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });

        for(int i=0;i<n;i++){
            events[i][0]--;
        }

        return fun(0,k);
    }
}