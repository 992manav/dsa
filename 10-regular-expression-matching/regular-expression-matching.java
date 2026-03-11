class Solution {
    int n;
    int m;
    String s;
    String p;

    boolean fun(int i,int j){
        if(i==n){
            if(j==m){
                return true;
            }else{
                while(j<m){
                    if(j+1<m && p.charAt(j+1)=='*'){
                        j+=2;
                    }else{
                        return false;
                    }
                }
                return true;
            }
        }

        if(j==m){
            return false;
        }

        boolean ans=false;

        if(j+1<m && p.charAt(j+1)=='*'){
            boolean no=fun(i,j+2);
            boolean considered=false;

            if(p.charAt(j)=='.' || p.charAt(j)==s.charAt(i)){
                considered=fun(i+1,j);
            }

            ans=ans | no | considered;
        }else if(p.charAt(j)=='.'){
            boolean take=fun(i+1,j+1);
            ans=ans | take;
        }else{
            if(s.charAt(i)!=p.charAt(j)){
                return false;
            }

            return fun(i+1,j+1);
        }

        return ans;
    }

    public boolean isMatch(String s, String p) {
        this.s=s;
        this.p=p;
        n=s.length();
        m=p.length();
        return fun(0,0);
    }
}