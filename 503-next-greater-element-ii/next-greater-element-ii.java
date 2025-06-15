class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result=new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
          
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
               result[i]=st.peek();
            } else {
                result[i]=-1;
            }

            st.push(nums[i]);
        }
        return result;
    }
}