class Solution {
    public String removeOuterParentheses(String s) {
       int count=0;
       int idx=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
               count++;
            }else{
                count--;
            }
            if(count==0){
                sb.append(s.substring(idx+1,i));
                idx=i+1;
            }
        }

    return sb.toString();
    }
}