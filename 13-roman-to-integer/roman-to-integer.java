class Solution {

   public int convert(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        } else {
            return 0; 
        }
    }


    public int romanToInt(String s) {
        int min=convert(s.charAt(0));
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int d=convert(c);
            if(d<=min){
                min=d;
                sum=sum+d;
            }else{
                sum=sum+d-min-min;
                min=d;
            }
        }
        return sum;
    }
}