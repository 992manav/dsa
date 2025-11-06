class Solution {
    int[] nums;
    int[][] queries;

    boolean check(int k){
        int n=nums.length;
        int[] prefix=new int[n+1];
        for(int i=0;i<k;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int val=queries[i][2];
            prefix[start]+=val;
            if(end+1<n) prefix[end+1]-=val;
        }
        for(int i=1;i<n;i++) prefix[i]+=prefix[i-1];
        for(int i=0;i<n;i++){
            if(prefix[i]<nums[i]) return false;
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums=nums;
        this.queries=queries;
        int low=0;
        int high=queries.length;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        // if(ans==queries.length) return -1;
        return ans;
    }
}
