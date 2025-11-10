import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int num = nums[i];

            if(st.isEmpty()){
                st.push(i);
                if(num!=0){
                    count++;
                }
                continue;
            }

            if(num > nums[st.peek()]){
                st.push(i);
                count++;
                continue;
            }

            boolean flag = (num==0);

            while(!st.isEmpty() && num <= nums[st.peek()]){
                if(num == nums[st.peek()]){
                    flag = true;
                }
                st.pop();
            }

            st.push(i);
            if(!flag){
                count++;
            }
        }
        return count;
    }
}
