class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        long exp=n;
        if(n<0){
            exp=exp*-1;
        }

        double res=1;
        while(exp!=0){
            if(exp%2==0){
                exp=exp/2;
                x=x*x;
            }else{
                res=res*x;
                exp=exp-1;
            }
        }
        
        if(n<0){
            return 1/res;
        }
        return res;
    }
}