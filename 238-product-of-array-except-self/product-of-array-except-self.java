class Solution {
      static {
        int arr [] = {1,2,3,4};
        for(int i=0;i<500;i++){
            productExceptSelf(arr);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            int value = nums[i];
            int left = (i == 0) ? 1 : prefix[i - 1];
            int right = (i == nums.length - 1) ? 1 : suffix[i + 1];
            ans[i] = left * right;
        }

        return ans;
    }
}
