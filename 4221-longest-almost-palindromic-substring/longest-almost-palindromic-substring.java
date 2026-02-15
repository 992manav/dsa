class Solution {
    int n;
    char[] c;
    String s;

    int expand(int i,int j,boolean flag){

        if(i<0 || j>=n){
            if(!flag){
                return (j-1)-(i+1)+1+1;  
            }else{
                return (j-1)-(i+1)+1;
            }
        }

        if(c[i]==c[j]){
            return expand(i-1,j+1,flag);
        }else{
            if(!flag){
                int deleteLeft = expand(i-1,j,true);
                int deleteRight = expand(i,j+1,true);
                return Math.max(deleteLeft, deleteRight);
            }else {
                return (j-1)-(i+1)+1;  // FIXED: current valid range before mismatch
            }
        }

    }

    public int almostPalindromic(String s) {
        c=s.toCharArray();
        n=s.length();
        this.s=s;
        int max=0;

        for(int i=0;i<n;i++){
            int odd=expand(i,i,false);
            int even=expand(i,i+1,false);

            if(odd>max){
                max=odd;
            }

            if(even>max){
                max=even;
            }

        }

        return Math.min(n,max);
    }
}