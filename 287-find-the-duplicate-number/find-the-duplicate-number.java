class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n;) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                if (i != correctIndex) {
                    return nums[i]; 
                } else {
                    i++; 
                }
            }
        }

        return -1; 
    }
}
