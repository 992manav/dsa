class Solution {
    public int minFlips(int a, int b, int c) {
        
        int temp=c;
        int count=0;
        while(temp!=0 || a!=0 || b!=0){
           int target = temp & 1;
            int la=a & 1;
            int lb=b & 1;

            if(target==1){
               if(la==0){
                if(lb==0){
                    count++;
                }
               }
            }else{
                if(la==1){
                    count++;
                }
                if(lb==1){
                    count++;
                }

            }

            temp=temp>>1;
            a=a>>1;
            b=b>>1;
        }

        return count;

    }
}