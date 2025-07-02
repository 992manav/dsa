class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1; 

        while (i < j) {

            int left = nums[i];
            int right = nums[j];

            if (left + right == target) {
                return new int[]{i+1, j+1};
            }

            if (target - left > right) {
                i++;
            } else if (target - left < right) {
                j--; 
            }
        }

        return new int[]{}; 
    }
}
