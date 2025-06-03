class Solution {

    long mod = 1_000_000_007L;
    
    public long myPow(long x, long exp) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        long res=1;
        while(exp!=0){
            if(exp%2==0){
                exp=exp/2;
                x=(x*x)%mod;

            }else{
                res=(res*x)%mod;
                exp=exp-1;
            }
        }

        return res;
    }

    public int countGoodNumbers(long n) {
       
        long no_of_even = n / 2 + n % 2;
        long no_of_odd = n - no_of_even;

        long even = myPow(5, no_of_even);
        long odd = myPow(4, no_of_odd);

        return (int)((even * odd) % mod);
    }

    

}
