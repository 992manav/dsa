class Solution { 
    public int countNumbersWithUniqueDigits(int n) { 
        if (n == 0) return 1;

        int res = 10;

        for (int i = 2; i <= n && i <= 10; i++) { 
            int mul = 9; 
            int available = 9;

            for (int j = 1; j < i; j++) { 
                mul *= available; 
                available--; 
            } 
            res += mul; 
        } 

        return res; 
    } 
}
