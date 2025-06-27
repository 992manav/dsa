import java.util.ArrayDeque;

class Solution { 
    public boolean canJump(int[] nums) { 
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(nums.length - 1);
        
        for (int i = nums.length - 2; i >= 0; i--) { 
            if (i + nums[i] >= stack.peek()) {
                stack.push(i);
            } 

            if (i == 0 && i + nums[i] < stack.peek()) {
                return false;
            }
        } 
        return true; 
    } 
}
