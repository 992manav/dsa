class Solution {
    public int countTriples(int n) {

        int count = 0;
        // 1 se leke n tak maan lo ek array hai sorted (1 to n),
        // uska advantage le rahe hain
        // 3Sum without map approach, matlab two-pointer approach
        // c ko fix kar rahe hain (largest side)
        for (int c = n; c >= 2; c--) {

            int target = c * c;
            int l = 1, r = c - 1;

            // Two Pointer (3Sum jaisa)
            while (l < r) {
                int sum = l * l + r * r;

                if (sum == target) {
                    count += 2;   // (l, r, c) & (r, l, c)
                    l++;
                    r--;
                } 
                else if (sum < target) {
                    l++;          // sum badhao
                } 
                else {
                    r--;          // sum ghatao
                }
            }
        }
        return count;
    }
}
