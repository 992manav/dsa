class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res=10;
        for(int i=n;i>1;i--){
            int k=9;
            int mul=1;
            for(int j=0;j<i-1;j++){
                mul=mul*k;
                k--;
            }
            res=res+mul*9;
        }

        return res;
    }
}