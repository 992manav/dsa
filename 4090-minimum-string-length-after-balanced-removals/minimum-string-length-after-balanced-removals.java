class Solution {
    public int minLengthAfterRemovals(String s) {
        int count=0;
        for(char c: s.toCharArray()){
            if(c=='a'){
                count++;
            }else{
                count--;
            }
        }
        return Math.abs(count);
    }
}