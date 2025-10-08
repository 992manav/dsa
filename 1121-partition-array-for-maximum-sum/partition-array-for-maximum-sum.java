class Solution {
    int[] arr;
    int k;
    int[] dp;

    public int fun(int index) {
        if (index >= arr.length) return 0;
        if (dp[index] != -1) return dp[index];

        int max = 0, res = 0;
        for (int i = 0; i < k && index + i < arr.length; i++) {
            max = Math.max(max, arr[index + i]);
            res = Math.max(res, max * (i + 1) + fun(index + i + 1));
        }

        dp[index] = res;
        return res;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        this.dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return fun(0);
    }
}
