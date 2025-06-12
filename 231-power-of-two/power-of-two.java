class Solution {

    boolean check_power_of_two(int N) {
        if ((N & 1) == 1) {
            if (N == 1) {
                return true;
            }
            return false;
        }
       
        N = N >> 1;
        return check_power_of_two(N);
    }

    public boolean isPowerOfTwo(int n) {
        
        if (n <= 0) return false;

       return check_power_of_two(n);
    }
}
