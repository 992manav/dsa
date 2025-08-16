class Solution {
    
    int n;

    int fun(int curr_A, int clipboard, int steps) {
        if (curr_A > n) return Integer.MAX_VALUE;
        if (curr_A == n) return steps;

        int ans = Integer.MAX_VALUE;

        // Copy (sirf tab jab clipboard alag ho, warna repeat hoga)
        if (clipboard != curr_A) {
            ans = Math.min(ans, fun(curr_A, curr_A, steps + 1));
        }

        // Paste (sirf tab jab kuch clipboard mein ho)
        if (clipboard > 0) {
            ans = Math.min(ans, fun(curr_A + clipboard, clipboard, steps + 1));
        }

        return ans;
    }
    
    public int minSteps(int n) {
        this.n = n;
        return fun(1, 0, 0);
    }
}
