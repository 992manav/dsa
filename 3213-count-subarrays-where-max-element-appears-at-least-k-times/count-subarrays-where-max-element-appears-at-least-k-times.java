import java.util.*;
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int x:nums){
            if(x>max) max = x;
        }

        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                lst.add(i);
            }
        }

        long tot=0;
        int index=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                index++;
            }

            if(index>=k-1){
                int ind=index-k+1;
                int j=lst.get(ind);
                tot += j+1;
            }
        }
        return tot;
    }
}
