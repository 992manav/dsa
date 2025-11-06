class Solution {
    int[] a;
    int[][] q;

    boolean ok(int k){
        int n=a.length;
        int[] p=new int[n+1];
        for(int i=0;i<k;i++){
            int[] x=q[i];
            int s=x[0],e=x[1],v=x[2];
            p[s]+=v;
            if(e+1<n) p[e+1]-=v;
        }
        for(int i=1;i<n;i++) p[i]+=p[i-1];
        for(int i=0;i<n;i++) if(p[i]<a[i]) return false;
        return true;
    }

    public int minZeroArray(int[] nums,int[][] queries){
        a=nums;
        q=queries;
        int l=0,r=q.length,ans=-1;
        while(l<=r){
            int m=(l+r)>>1;
            if(ok(m)){
                ans=m;
                r=m-1;
            }else l=m+1;
        }
        return ans;
    }
}
