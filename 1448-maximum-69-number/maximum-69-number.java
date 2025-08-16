class Solution {
    public int maximum69Number (int num) {
        int n = num;
        int index = 0;   
        int pos = -1;
        
        while (n != 0) {
            int r = n % 10;
            index++;
            if (r == 6) {
                pos = index;
            }
            n = n / 10;
        }

        if (pos != -1) {    
            int mult = (int)Math.pow(10, pos - 1); 
            return mult * 3 + num;
        }

        return num;
    }
}
