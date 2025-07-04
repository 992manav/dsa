class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        Set<Integer> cha =new HashSet<>();
    
        for(int i=0;i<n;i++)
        {
            if(!cha.add(nums[i]))
            {
               
                return true;
            }
        }
        return false;

        
    }
}