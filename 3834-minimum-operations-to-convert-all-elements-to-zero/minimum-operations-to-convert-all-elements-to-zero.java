import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            int num = nums[i];

            if(stack.isEmpty()){
                stack.push(i);
                if(num!=0){
                    count++;
                }
                continue;
            }

            if(num > nums[stack.peek()]){
                stack.push(i);
                count++;
                continue;
            }

            boolean flag = (num==0);

            while(!stack.isEmpty() && num <= nums[stack.peek()]){
                if(num == nums[stack.peek()]){
                    flag = true;
                }
                stack.pop();
            }

            stack.push(i);
            if(!flag){
                count++;
            }
        }
        return count;
    }
}
