class Solution {
    int[] a;
    int[][] q;
    int[] p;

    boolean ok(int k){
        int n=a.length;
        for(int i=0;i<=n;i++) p[i]=0;
        for(int i=0;i<k;i++){
            int[] x=q[i];
            p[x[0]]+=x[2];
            int e=x[1]+1;
            if(e<n) p[e]-=x[2];
        }
        for(int i=1;i<n;i++) p[i]+=p[i-1];
        for(int i=0;i<n;i++) if(p[i]<a[i]) return false;
        return true;
    }

    public int minZeroArray(int[] nums,int[][] queries){
        a=nums;
        q=queries;
        p=new int[a.length+1];
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
