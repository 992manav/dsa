class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int left=0;
        for (int i=0; i<n; ++i)
        {
            left = i%k==0 ? nums[i] : Math.max(left, nums[i]);
            
            if (i+1>=k) {
                result[i+1-k] = left;
                System.out.print(result[i+1-k] + " ");
            }
        }
        System.out.println();
        int right=0;
        for (int i=n-1; i>=0; i--)
        {
            right = (i%k==k-1 || i==n-1) ? nums[i] : Math.max(right, nums[i]);

            if (i <= n - k) {
                System.out.print(right + " ");
                result[i] = Math.max(result[i], right);
            }
        }
        return result;
    }
}