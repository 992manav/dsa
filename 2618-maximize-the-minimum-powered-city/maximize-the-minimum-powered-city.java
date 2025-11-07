class Solution {

    long[] base;
    int n;
    int r;
    long k;

   boolean check(long target){
        long left=k;
        long add=0;
        long[] diff=new long[n+2*r+5];
        int i=0;
        while(i<n){
            add=add+diff[i];
            long cur=base[i]+add;
            if(cur<target){
                long need=target-cur;
                if(need>left) return false;
                left=left-need;
                add=add+need;
                int pos=i+2*r+1;
                if(pos<diff.length) diff[pos]=diff[pos]-need;
            }
            i=i+1;
        }
        return true;
    }


    public long maxPower(int[] sta, int r, int k) {
        this.n=sta.length;
        this.r=r;
        this.k=k;
        int len=n+2*r+5;
        long[] diff=new long[len];
        int i=0;
        while(i<n){
            int L=i-r;
            int R=i+r;
            if(L<0)L=0;
            if(R>=n)R=n-1;
            diff[L]=diff[L]+sta[i];
            diff[R+1]=diff[R+1]-sta[i];
            i=i+1;
        }
        base=new long[n];
        long cur=0;
        long min=1000000000000L;
        long sum=k;
        i=0;
        while(i<n){
            cur=cur+diff[i];
            base[i]=cur;
            if(base[i]<min)min=base[i];
            sum=sum+sta[i];
            i=i+1;
        }
        long low=min;
        long high=sum;
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(check(mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
