class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int n=s.length();
        boolean[] valid=new boolean[n];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(c==')'){
                if(st.isEmpty()){
                    continue;
                }else{
                    valid[i]=true;
                    valid[st.pop()]=true;
                }
            }else{
                st.push(i);
            }
        }

        int max=0;
        int l=-1;
        for(int i=0;i<n;i++){
            if(valid[i]==false){
                l=i;
            }
            int len=i-l;
            max=Math.max(max,len);
        }
        return max;
    }
}