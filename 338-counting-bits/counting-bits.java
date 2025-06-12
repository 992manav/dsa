class Solution {

    int fun(int n, int sum) {
        if (n == 0) {
            return sum ;
        }
        return fun(n / 2, sum + n % 2);
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1]; 
        for (int i = 0; i <= n; i++) { 
            res[i] = fun(i, 0); 
        }
        return res; 
    }
}
