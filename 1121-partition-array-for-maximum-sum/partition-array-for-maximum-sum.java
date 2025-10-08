class Solution {

    int[] arr;
    int k;
    int[][] dp;

    public int fun(int noElePrevPartition, int index, int prevPartitionMax, int sum) {
        if (index >= arr.length) {
            return sum;
        }

        if (dp[index][noElePrevPartition] != -1) {
            // dp stores the best result from this state onwards, not total sum
            return dp[index][noElePrevPartition] + sum;
        }

        int combine = 0;
        int notCombine = 0;
        int currEle = arr[index];

        if (noElePrevPartition < k) {
            int max = prevPartitionMax;
            int newSum = sum;

            if (currEle > prevPartitionMax) {
                max = currEle;
                newSum = sum - (prevPartitionMax * noElePrevPartition)
                        + ((noElePrevPartition + 1) * currEle);
            } else {
                newSum += prevPartitionMax;
            }

            combine = fun(noElePrevPartition + 1, index + 1, max, newSum);
        }

        notCombine = fun(1, index + 1, currEle, sum + currEle);

        int ans = Math.max(combine, notCombine);
        dp[index][noElePrevPartition] = ans - sum; // store only the remaining part
        return ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        this.dp = new int[arr.length + 1][k + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, 0, 0, 0);
    }
}
