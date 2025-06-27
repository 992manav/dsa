import java.util.Stack;

class Solution { 
    public boolean canJump(int[] nums) { 
        Stack<Integer> st = new Stack<>();
        st.push(nums.length - 1);
        
        for (int i = nums.length - 2; i >= 0; i--) { 
            if (i + nums[i] >= st.peek()) {
                st.push(i);
            } 

            if(i==0){
                if (i + nums[i] < st.peek()) {
                    return false;
                } 
            }
        } 
        return true; 
    } 
}
