class Solution {

    int fun(int n, int[] res) {
        if (n == 0) return 0;

        if((n & 1)==0){
            return res[n]=res[n/2];        
        }else{
            return res[n]=res[n/2]+1;
        }

        // if (res[n] != -1) return res[n];

        // res[n] = fun(n / 2, res) + (n % 2);  // bit count = count(n/2) + n%2
        // return res[n];
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        // Initialize all values to -1 (indicating not calculated)
        for (int i = 0; i <= n; i++) {
            res[i] = -1;
        }
        res[0] = 0;

        for (int i = 0; i <= n; i++) {
          
            fun(i, res); // fill using memoized function
        }

        return res;
    }
}
