class Solution {
    public int countValidSelections(int[] nums) {
        int pref[]  = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            pref[i] = pref[i-1]+nums[i-1];
        }
        int suff[] = new int[nums.length+1];
        for(int i=nums.length;i>=1;i--){
            suff[i-1] = suff[i]+nums[i-1];
        }
        int count=0;
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]==0){
                if(pref[i]==suff[i]) count+=2;
                if(pref[i]==suff[i]+1) count+=1;
                if(pref[i]==suff[i]-1) count+=1;
            }
        }
        return count;
    }
}