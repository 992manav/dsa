class Solution {
    int[] prefix;
    long f;
    long e;
    int n;

    long fun(int i,int j){
        
        if(i>j || i<0 || j>=n){
            return Long.MAX_VALUE;
        }

        int x;
        if(i==0){
            x=prefix[j];
        }else{
            x=prefix[j]-prefix[i-1];
        }
        
        int len=j-i+1;
        long cur=0;
        if(x==0){
            cur=f;
        }else{
            cur=(long)len*x*e;
        }
        
        if(len>=2 && len%2==0 && x!=0){
            int mid=(i+j)/2;

            long ls=fun(i,mid);
            long rs=fun(mid+1,j);

            if(ls+rs<cur){
                return ls+rs;
            }

        }
        
        return cur;

    }

    public long minCost(String s, int e, int f) {
        this.f=f;
        this.e=e;
        n=s.length();
        prefix=new int[n];

        if(s.charAt(0)=='1'){
            prefix[0]=1;
        }else{
            prefix[0]=0;
        }

        for(int i=1;i<n;i++){
            if(s.charAt(i)=='1'){
                prefix[i]=prefix[i-1]+1;
            }else{
                prefix[i]=prefix[i-1];
            }
        }

        return fun(0,n-1);
    }
}