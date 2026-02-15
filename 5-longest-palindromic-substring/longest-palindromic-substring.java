class Solution {
    int n;
    char[] c;
    String s;
    String expand(int i,int j){

        while(i>=0 && j<n){
            if(c[i]!=c[j]){
                break;
            }
            i--;
            j++;
        }


        return s.substring(i+1,j);

    }
    public String longestPalindrome(String s) {
        c=s.toCharArray();
        n=s.length();
        this.s=s;
        String ans=s.charAt(0)+"";
        for(int i=0;i<n;i++){
            String odd=expand(i,i);
            String even=expand(i,i+1);

            if(ans.length()<odd.length()){
                ans=odd;
            }

            if(ans.length()<even.length()){
                ans=even;
            }

        }

        return ans;
    }
}