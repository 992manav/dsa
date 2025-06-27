class Solution { 
    public boolean canJump(int[] nums) { 
        int nextPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) { 
            if (i + nums[i] >= nextPos) {
                nextPos = i;
            }

            if (i == 0 && i + nums[i] < nextPos) {
                return false;
            }
        } 
        
        return true; 
    } 
}
