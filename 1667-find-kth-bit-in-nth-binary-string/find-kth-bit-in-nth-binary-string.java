class Solution {

    char fun(int n,int k,boolean flag){
        if(n==1){
            if(flag){
                return '0';
            }else{
               return '1';
            }
        }

        int mid = (n + 1) / 2;

        if(k < mid){
            return fun(n/2,k,flag);
        }else if(k == mid){
            if(flag){
                return '1';
            }else{
                return '0';
            }
        }else{
            int idx = n - k + 1;
            return fun(n/2,idx,!flag);
        }
    }

    public char findKthBit(int n, int k) {
        int len = (1 << n) - 1;
        return fun(len,k,true);
    }
}